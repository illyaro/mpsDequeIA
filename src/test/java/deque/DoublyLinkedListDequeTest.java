package deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Double Linked List Deque")
class DoublyLinkedListDequeTest {

    protected DoublyLinkedListDeque<Integer> deque;

    @BeforeEach
    void setUp() {
        deque = new DoublyLinkedListDeque<>();
    }

    @AfterEach
    void tearDown() {
        deque = null;
    }

    @Nested
    @DisplayName("With empty deque")
    class EmptyDequeTests {

        @Test
        @DisplayName("Size is equal to zero")
        void emptyDequeHasSizeEqualToZero() {
            int expectedValue = 0;
            int actualValue = deque.size();
            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("Exception is thrown when first is called")
        void emptyDequeThrowsAnExceptionWhenFirstIsCalled() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.first());
        }

        @Test
        @DisplayName("Exception is thrown when last is called")
        void emptyDequeThrowsAnExceptionWhenLastIsCalled() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.last());
        }

        @Nested
        @DisplayName("Exception Messages are correct")
        class ExceptionMessagesChecks {
            @Test
            @DisplayName("When first is called")
            void exceptionMessageOfDoubleEndedQueueExceptionIsCorrectWhenFirstIsCalled() {
                DoubleEndedQueueException exception = assertThrows(DoubleEndedQueueException.class, () -> deque.first());
                String expectedMessage = "ERROR: Queue is empty.";
                String actualMessage = exception.getMessage();
                assertEquals(expectedMessage, actualMessage);
            }

            @Test
            @DisplayName("When last is called")
            void exceptionMessageOfDoubleEndedQueueExceptionIsCorrectWhenLastIsCalled() {
                DoubleEndedQueueException exception = assertThrows(DoubleEndedQueueException.class, () -> deque.last());
                String expectedMessage = "ERROR: Queue is empty.";
                String actualMessage = exception.getMessage();
                assertEquals(expectedMessage, actualMessage);
            }

            @Test
            @DisplayName("When delete first is called")
            void exceptionMessageOfDoubleEndedQueueExceptionIsCorrectWhenDeleteFirstIsCalled() {
                DoubleEndedQueueException exception = assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
                String expectedMessage = "ERROR: Queue is empty.";
                String actualMessage = exception.getMessage();
                assertEquals(expectedMessage, actualMessage);
            }

            @Test
            @DisplayName("When delete last is called")
            void exceptionMessageOfDoubleEndedQueueExceptionIsCorrectWhenDeleteLastIsCalled() {
                DoubleEndedQueueException exception = assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
                String expectedMessage = "ERROR: Queue is empty.";
                String actualMessage = exception.getMessage();
                assertEquals(expectedMessage, actualMessage);
            }
        }
    }

    @Test
    void prependTest(){
        deque.prepend(Integer.valueOf(5));
        assertEquals(5, deque.first());
        assertEquals(5,deque.last());
        assertEquals(1, deque.size());
    }
}