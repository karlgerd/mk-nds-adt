package mk.nds.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void followsLastInFirstOutOrder() {
        Stack<String> stack = new Stack<>();
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
    void topDoesNotRemoveTheItem() {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        assertEquals("A", stack.top());
        assertEquals("A", stack.top());
        assertFalse(stack.isEmpty());
    }

    @Test
    void keepsOrderWithManyItems() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 1000; i++) {
            stack.push(i);
        }
        for (int i = 999; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    void canBeFilledAgainAfterBeingEmptied() {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.pop();
        stack.push("B");
        assertEquals("B", stack.top());
        assertEquals("B", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void rejectsNullAndOperationsOnAnEmptyStack() {
        Stack<String> stack = new Stack<>();
        assertThrows(IllegalArgumentException.class, () -> stack.push(null));
        assertThrows(NoSuchElementException.class, stack::top);
        assertThrows(NoSuchElementException.class, stack::pop);

        stack.push("A");
        stack.pop();
        assertThrows(NoSuchElementException.class, stack::top);
        assertThrows(NoSuchElementException.class, stack::pop);
    }

    @Test
    @SuppressWarnings({ "rawtypes", "unchecked" })
    void canBeUsedWithoutTypeArgument() {
        Stack stack = new Stack();
        stack.push("A");
        stack.push(1);
        assertEquals(1, stack.pop());
        assertEquals("A", stack.pop());
    }
}
