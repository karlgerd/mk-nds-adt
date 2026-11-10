package mk.nds.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BinTreeTest {
    @Test
    void createsAndFillsAnEmptyTree() {
        BinTree<String> tree = new BinTree<>();
        assertTrue(tree.isEmpty());
        assertThrows(IllegalStateException.class, tree::getItem);
        assertThrows(IllegalStateException.class, tree::isLeaf);

        tree.setItem("Wurzel");
        assertFalse(tree.isEmpty());
        assertTrue(tree.isLeaf());
        assertEquals("Wurzel", tree.getItem());
    }

    @Test
    void storesAndReplacesSubtrees() {
        BinTree<Integer> tree = new BinTree<>(1);
        BinTree<Integer> left = new BinTree<>(2);
        BinTree<Integer> right = new BinTree<>(3);

        tree.setLeft(left);
        tree.setRight(right);

        assertEquals(left, tree.getLeft());
        assertEquals(right, tree.getRight());
        assertFalse(tree.isLeaf());
        assertThrows(IllegalStateException.class, () -> new BinTree<Integer>().getLeft());
        assertThrows(IllegalStateException.class, () -> new BinTree<Integer>().getRight());
    }

    @Test
    void rejectsNullContentsAndSubtrees() {
        assertThrows(IllegalArgumentException.class, () -> new BinTree<String>(null));
        assertThrows(IllegalArgumentException.class, () -> new BinTree<String>().setItem(null));

        BinTree<String> tree = new BinTree<>("Wurzel");
        assertThrows(IllegalArgumentException.class, () -> tree.setLeft(null));
        assertThrows(IllegalArgumentException.class, () -> tree.setRight(null));
    }

    @Test
    void canBeEmptiedAgain() {
        BinTree<String> tree = new BinTree<>("Wurzel");
        tree.setEmpty();

        assertTrue(tree.isEmpty());
        assertThrows(IllegalStateException.class, tree::getItem);
    }
}
