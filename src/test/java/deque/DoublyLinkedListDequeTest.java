package deque;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DoublyLinkedListDequeTest {

    protected DoublyLinkedListDeque<Integer> deque;
    @BeforeEach
    void setUp(){
        deque = new DoublyLinkedListDeque<>();
    }

    @AfterEach
    void tearDown(){
        deque = null;
    }

    @Test
    void EmptyDequeHasSizeEqualToZero(){
        int expectedValue = 0;
        int actualValue = deque.size();
        assertEquals(expectedValue, actualValue);
    }
}