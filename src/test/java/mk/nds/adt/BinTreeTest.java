package mk.nds.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class BinTreeTest {

    @Test
    void createsAndFillsAnEmptyTree() {
        BinTree<String> tree = new BinTree<>();
        assertTrue(tree.isEmpty());

        tree.setItem("Wurzel");
        assertFalse(tree.isEmpty());
        assertTrue(tree.isLeaf());
        assertEquals("Wurzel", tree.getItem());
        assertTrue(tree.getLeft().isEmpty());
        assertTrue(tree.getRight().isEmpty());
    }

    @Test
    void constructorWithContentCreatesALeaf() {
        BinTree<String> tree = new BinTree<>("Wurzel");
        assertFalse(tree.isEmpty());
        assertTrue(tree.isLeaf());
        assertEquals("Wurzel", tree.getItem());
        assertTrue(tree.getLeft().isEmpty());
        assertTrue(tree.getRight().isEmpty());
    }

    @Test
    void storesAndReplacesSubtrees() {
        BinTree<Integer> tree = new BinTree<>(1);
        BinTree<Integer> left = new BinTree<>(2);
        BinTree<Integer> right = new BinTree<>(3);
        tree.setLeft(left);
        tree.setRight(right);
        assertSame(left, tree.getLeft());
        assertSame(right, tree.getRight());
        assertFalse(tree.isLeaf());

        BinTree<Integer> newLeft = new BinTree<>(4);
        tree.setLeft(newLeft);
        assertSame(newLeft, tree.getLeft());
    }

    @Test
    void subtreeCanBeFilledThroughItsReference() {
        BinTree<String> tree = new BinTree<>("A");
        tree.getLeft().setItem("B");
        tree.getRight().setItem("C");

        assertFalse(tree.isLeaf());
        assertEquals("B", tree.getLeft().getItem());
        assertEquals("C", tree.getRight().getItem());
        assertTrue(tree.getLeft().isLeaf());
        assertTrue(tree.getRight().isLeaf());
    }

    @Test
    void setItemOnFilledTreeKeepsSubtrees() {
        BinTree<String> tree = new BinTree<>("A");
        BinTree<String> left = new BinTree<>("B");
        tree.setLeft(left);
        tree.setItem("Z");
        assertEquals("Z", tree.getItem());
        assertSame(left, tree.getLeft());
    }

    @Test
    void rejectsReadingFromAnEmptyTree() {
        BinTree<String> tree = new BinTree<>();
        assertThrows(NoSuchElementException.class, tree::getItem);
        assertThrows(NoSuchElementException.class, tree::isLeaf);
        assertThrows(NoSuchElementException.class, tree::getLeft);
        assertThrows(NoSuchElementException.class, tree::getRight);
    }

    @Test
    void rejectsSettingSubtreesOfAnEmptyTree() {
        BinTree<String> tree = new BinTree<>();
        assertThrows(IllegalStateException.class, () -> tree.setLeft(new BinTree<>("A")));
        assertThrows(IllegalStateException.class, () -> tree.setRight(new BinTree<>("A")));
    }

    @Test
    void rejectsNullContentsAndSubtrees() {
        assertThrows(IllegalArgumentException.class, () -> new BinTree<String>(null));
        assertThrows(IllegalArgumentException.class, () -> new BinTree<String>().setItem(null));
        BinTree<String> tree = new BinTree<>("Wurzel");
        assertThrows(IllegalArgumentException.class, () -> tree.setItem(null));
        assertThrows(IllegalArgumentException.class, () -> tree.setLeft(null));
        assertThrows(IllegalArgumentException.class, () -> tree.setRight(null));
    }

    @Test
    void canBeEmptiedAgain() {
        BinTree<String> tree = new BinTree<>("Wurzel");
        tree.setLeft(new BinTree<>("Links"));
        tree.setEmpty();
        assertTrue(tree.isEmpty());
        assertThrows(NoSuchElementException.class, tree::getItem);
        assertThrows(NoSuchElementException.class, tree::getLeft);

        tree.setItem("Neu");
        assertTrue(tree.isLeaf());
    }

    @Test
    @SuppressWarnings({ "rawtypes", "unchecked" })
    void canBeUsedWithoutTypeArgument() {
        BinTree tree = new BinTree("Wurzel");
        tree.setLeft(new BinTree(1));
        assertEquals("Wurzel", tree.getItem());
        assertEquals(1, tree.getLeft().getItem());
    }
}
