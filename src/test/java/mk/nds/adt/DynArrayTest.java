package mk.nds.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class DynArrayTest {
    @Test
    void appendsInsertsReplacesAndDeletesItems() {
        DynArray array = new DynArray();
        array.append("A");
        array.append("C");
        array.insertAt(1, "B");
        array.insertAt(3, "D");
        array.setItem(2, "c");

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
    void rejectsNullAndOutOfRangeIndexes() {
        DynArray array = new DynArray();
        assertThrows(IllegalArgumentException.class, () -> array.append(null));
        assertThrows(IllegalArgumentException.class, () -> array.insertAt(0, null));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(0));
        assertThrows(IndexOutOfBoundsException.class, () -> array.setItem(0, "A"));
        assertThrows(IndexOutOfBoundsException.class, () -> array.delete(0));
        assertThrows(IndexOutOfBoundsException.class, () -> array.insertAt(-1, "A"));

        array.append("A");
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.getItem(1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.insertAt(2, "B"));
        assertThrows(IndexOutOfBoundsException.class, () -> array.setItem(1, "B"));
        assertThrows(IndexOutOfBoundsException.class, () -> array.delete(1));
    }

    @Test
    void iteratorVisitsEveryItemAndThrowsAfterTheEnd() {
        DynArray array = new DynArray();
        array.append("A");
        array.append("B");

        Iterator<Object> iterator = array.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
        assertFalse(new DynArray().iterator().hasNext());
    }
}
