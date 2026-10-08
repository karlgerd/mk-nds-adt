package mk.nds.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StackTest {
    @Test
    void followsLastInFirstOutOrder() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());

        stack.push("A");
        stack.push("B");
        assertFalse(stack.isEmpty());
        assertEquals("B", stack.top());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.top());
        assertEquals("A", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void rejectsNullAndOperationsOnAnEmptyStack() {
        Stack stack = new Stack();
        assertThrows(IllegalArgumentException.class, () -> stack.push(null));
        assertThrows(IllegalStateException.class, stack::top);
        assertThrows(IllegalStateException.class, stack::pop);

        stack.push("A");
        stack.pop();
        assertThrows(IllegalStateException.class, stack::top);
        assertThrows(IllegalStateException.class, stack::pop);
    }
}
