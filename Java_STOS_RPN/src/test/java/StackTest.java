import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testPushAndPop() {
        Stack stack = new Stack();
        stack.push("napis1");
        stack.push("napis2");

        assertEquals("napis2", stack.pop());
        assertEquals("napis1", stack.pop());
    }

    @Test
    public void testPeek() {
        Stack stack = new Stack();
        stack.push("napis");

        assertEquals("napis", stack.peek());
        assertEquals("napis", stack.peek()); // Peek nie usuwa elementu
    }

    @Test
    public void testIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());

        stack.push("napis");
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopOnEmptyStack() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    public void testPeekOnEmptyStack() {
        Stack stack = new Stack();
        assertThrows(IllegalStateException.class, stack::peek);
    }
}
