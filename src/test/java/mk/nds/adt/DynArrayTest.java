package mk.nds.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class DynArrayTest {

    @Test
    void newArrayIsEmpty() {
        DynArray<String> array = new DynArray<>();
        assertTrue(array.isEmpty());
        assertEquals(0, array.getLength());
    }

    @Test
    void appendsInsertsReplacesAndDeletesItems() {
        DynArray<String> array = new DynArray<>();
        array.append("A");
        array.append("C");
        array.insertAt(1, "B");
        array.insertAt(3, "D");
        array.setItem(2, "c");

        assertFalse(array.isEmpty());
        assertEquals(4, array.getLength());
        assertEquals("A", array.getItem(0));
        assertEquals("B", array.getItem(1));
        assertEquals("c", array.getItem(2));
        assertEquals("D", array.getItem(3));

        array.delete(1);
        array.delete(2);
        assertEquals(2, array.getLength());
        assertEquals("A", array.getItem(0));
        assertEquals("c", array.getItem(1));
    }

    @Test
    void insertsAndDeletesAtStartMiddleAndEnd() {
        DynArray<Integer> array = new DynArray<>();
        array.append(2);
        array.insertAt(0, 0);
        array.insertAt(1, 1);
        array.insertAt(3, 3);
        for (int i = 0; i < 4; i++) {
            assertEquals(i, array.getItem(i));
        }

        array.delete(3);
        array.delete(0);
        assertEquals(2, array.getLength());
        assertEquals(1, array.getItem(0));
        assertEquals(2, array.getItem(1));

        array.delete(0);
        array.delete(0);
        assertTrue(array.isEmpty());
    }

    @Test
    void growsBeyondInitialCapacity() {
        DynArray<Integer> array = new DynArray<>();
        for (int i = 0; i < 1000; i++) {
            array.append(i);
        }
        array.insertAt(500, -1);

        assertEquals(1001, array.getLength());
        assertEquals(499, array.getItem(499));
        assertEquals(-1, array.getItem(500));
        assertEquals(500, array.getItem(501));
        assertEquals(999, array.getItem(1000));
    }

    @Test
    void rejectsNullAndOutOfRangeIndexes() {
        DynArray<String> array = new DynArray<>();
        assertThrows(IllegalArgumentException.class, () -> array.append(null));
        assertThrows(IllegalArgumentException.class, () -> array.insertAt(0, null));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(0));
        assertThrows(IndexOutOfBoundsException.class, () -> array.setItem(0, "A"));
        assertThrows(IndexOutOfBoundsException.class, () -> array.delete(0));
        assertThrows(IndexOutOfBoundsException.class, () -> array.insertAt(-1, "A"));

        array.append("A");
        assertThrows(IllegalArgumentException.class, () -> array.setItem(0, null));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.insertAt(2, "B"));
        assertThrows(IndexOutOfBoundsException.class, () -> array.setItem(1, "B"));
        assertThrows(IndexOutOfBoundsException.class, () -> array.delete(1));
    }

    @Test
    void iteratorVisitsEveryItemAndThrowsAfterTheEnd() {
        DynArray<String> array = new DynArray<>();
        array.append("A");
        array.append("B");

        Iterator<String> iterator = array.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
        assertFalse(new DynArray<String>().iterator().hasNext());
    }

    @Test
    void forEachVisitsItemsInOrder() {
        DynArray<String> array = new DynArray<>();
        array.append("A");
        array.append("B");
        array.append("C");

        StringBuilder result = new StringBuilder();
        for (String item : array) {
            result.append(item);
        }
        assertEquals("ABC", result.toString());
    }

    @Test
    void forEachRejectsStructuralChanges() {
        DynArray<String> array = new DynArray<>();
        array.append("A");
        array.append("B");
        array.append("C");

        assertThrows(ConcurrentModificationException.class, () -> {
            for (String item : array) {
                array.append(item);
            }
        });
        assertThrows(ConcurrentModificationException.class, () -> {
            for (String item : array) {
                array.insertAt(0, item);
            }
        });
        assertThrows(ConcurrentModificationException.class, () -> {
            for (String item : array) {
                array.delete(0);
            }
        });
    }

    @Test
    void forEachRejectsStructuralChangesInEveryPass() {
        // Jede Position einzeln prüfen, besonders den vorletzten und letzten
        // Durchlauf: Dort würde ein delete sonst still die Schleife beenden.
        for (int pass = 0; pass < 3; pass++) {
            int changeInPass = pass;

            DynArray<String> deleting = createABC();
            assertThrows(ConcurrentModificationException.class,
                    () -> changeDuringForEach(deleting, changeInPass, () -> deleting.delete(0)));

            DynArray<String> appending = createABC();
            assertThrows(ConcurrentModificationException.class,
                    () -> changeDuringForEach(appending, changeInPass, () -> appending.append("X")));

            DynArray<String> inserting = createABC();
            assertThrows(ConcurrentModificationException.class,
                    () -> changeDuringForEach(inserting, changeInPass, () -> inserting.insertAt(0, "X")));
        }
    }

    @Test
    void forEachRejectsDeletingTheLastItem() {
        DynArray<String> array = createABC();
        assertThrows(ConcurrentModificationException.class, () -> {
            for (String item : array) {
                if (item.equals("C")) {
                    array.delete(2);
                }
            }
        });
    }

    private static DynArray<String> createABC() {
        DynArray<String> array = new DynArray<>();
        array.append("A");
        array.append("B");
        array.append("C");
        return array;
    }

    private static void changeDuringForEach(DynArray<String> array, int changeInPass, Runnable change) {
        int pass = 0;
        for (String item : array) {
            if (pass == changeInPass) {
                change.run();
            }
            pass++;
        }
    }

    @Test
    void forEachAllowsReplacingItems() {
        DynArray<String> array = new DynArray<>();
        array.append("a");
        array.append("b");

        int index = 0;
        for (String item : array) {
            array.setItem(index, item.toUpperCase());
            index++;
        }
        assertEquals("A", array.getItem(0));
        assertEquals("B", array.getItem(1));
    }

    @Test
    @SuppressWarnings({ "rawtypes", "unchecked" })
    void canBeUsedWithoutTypeArgument() {
        DynArray array = new DynArray();
        array.append("A");
        array.append(1);
        assertEquals("A", array.getItem(0));
        assertEquals(1, array.getItem(1));
    }
}
