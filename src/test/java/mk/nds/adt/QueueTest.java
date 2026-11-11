package mk.nds.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    void followsFirstInFirstOutOrder() {
        Queue<String> queue = new Queue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue("A");
        queue.enqueue("B");
        assertFalse(queue.isEmpty());
        assertEquals("A", queue.head());
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.head());
        assertEquals("B", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void headDoesNotRemoveTheItem() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        assertEquals("A", queue.head());
        assertEquals("A", queue.head());
        assertFalse(queue.isEmpty());
    }

    @Test
    void keepsOrderWithManyItems() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 1000; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, queue.dequeue());
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    void canBeFilledAgainAfterBeingEmptied() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.dequeue();
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals("B", queue.head());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void rejectsNullAndOperationsOnAnEmptyQueue() {
        Queue<String> queue = new Queue<>();
        assertThrows(IllegalArgumentException.class, () -> queue.enqueue(null));
        assertThrows(NoSuchElementException.class, queue::head);
        assertThrows(NoSuchElementException.class, queue::dequeue);

        queue.enqueue("A");
        queue.dequeue();
        assertThrows(NoSuchElementException.class, queue::head);
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @Test
    @SuppressWarnings({ "rawtypes", "unchecked" })
    void canBeUsedWithoutTypeArgument() {
        Queue queue = new Queue();
        queue.enqueue("A");
        queue.enqueue(1);
        assertEquals("A", queue.dequeue());
        assertEquals(1, queue.dequeue());
    }
}
