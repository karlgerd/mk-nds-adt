package mk.nds.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class QueueTest {
    @Test
    void followsFirstInFirstOutOrder() {
        Queue queue = new Queue();
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
    void rejectsNullAndOperationsOnAnEmptyQueue() {
        Queue queue = new Queue();
        assertThrows(IllegalArgumentException.class, () -> queue.enqueue(null));
        assertThrows(IllegalStateException.class, queue::head);
        assertThrows(IllegalStateException.class, queue::dequeue);

        queue.enqueue("A");
        queue.dequeue();
        assertThrows(IllegalStateException.class, queue::head);
        assertThrows(IllegalStateException.class, queue::dequeue);
    }
}
