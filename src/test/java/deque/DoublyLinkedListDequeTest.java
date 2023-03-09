package deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Aryan Dilip Sadhwani Sadhwani
 * @author Illya Rozumovskyy
 */

/*
TEST CASES:
 size() of empty Deque is 0.
 first() of empty Deque throws exception.
 last() of empty Deque throws exception.
 DeleteFirst on empty Deque throws exception.
 DeleteLast on empty Deque throws exception.

 Prepend 5 to empty Deque : first() returns 5;
                            last() returns 5;
                            size() returns 1.

 Append 5 to empty Deque : first() returns 5;
                           last() returns 5;
                           size() returns 1.

 Prepend 2 to Deque containing 5 : first() returns 2;
                                   last() returns 5;
                                   size() returns 2.

 Append 2 to Deque containing 5 : first() returns 5;
                                  last() returns 2;
                                  size() returns 2.

DeleteFirst() of Deque containing 5: first() throws exception;
                                     last() throws exception;
                                     size() returns 0.

DeleteFirst() of Deque containing 5 and 2: first() returns 2;
                                           last() returns 2;
                                           size() returns 1.

DeleteLast() of Deque containing 5 and 2: first() returns 5;
                                           last() returns 5;
                                           size() returns 1.
 */
@DisplayName("Double Linked List Deque")
class DoublyLinkedListDequeTest {

    public DoublyLinkedListDeque<Integer> deque;

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

    @Nested
    @DisplayName("With valid deque")
    class validDequeTests {
        @Nested
        @DisplayName("Prepending 5 to an empty deque")
        class prependOneElementToEmptyDeque {
            @Test
            @DisplayName("First element is 5")
            void firstElementOfDequeIsFive() {
                deque.prepend(Integer.valueOf(5));
                Integer expectedResult = 5;
                Integer actualResult = deque.first();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Last element is 5")
            void lastElementIsFive() {
                deque.prepend(Integer.valueOf(5));
                Integer expectedResult = 5;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is 1")
            void sizeIsOne() {
                deque.prepend(Integer.valueOf(5));
                Integer expectedResult = 1;
                Integer actualResult = deque.size();
                assertEquals(expectedResult, actualResult);
            }
        }

            @Nested
            @DisplayName("Appending 5 to an empty deque")
            class appendOneElementToEmptyDeque {
                @Test
                @DisplayName("First element is 5")
                void firstElementOfDequeIsFive() {
                    deque.append(Integer.valueOf(5));
                    Integer expectedResult = 5;
                    Integer actualResult = deque.first();
                    assertEquals(expectedResult, actualResult);
                }

                @Test
                @DisplayName("Last element is 5")
                void lastElementIsFive() {
                    deque.append(Integer.valueOf(5));
                    Integer expectedResult = 5;
                    Integer actualResult = deque.last();
                    assertEquals(expectedResult, actualResult);
                }

                @Test
                @DisplayName("Size is 1")
                void sizeIsOne() {
                    deque.append(Integer.valueOf(5));
                    Integer expectedResult = 1;
                    Integer actualResult = deque.size();
                    assertEquals(expectedResult, actualResult);
                }

            }


        @Nested
        @DisplayName("Prepending 2 to a deque that contains 5.")
        class prependOneElementToDequeThatContainsOneElement {
            @Test
            @DisplayName("First element is 2")
            void firstElementOfDequeIsFive() {
                deque.append(Integer.valueOf(5));
                deque.prepend(Integer.valueOf(2));
                Integer expectedResult = 2;
                Integer actualResult = deque.first();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Last element is 5")
            void lastElementIsFive() {
                deque.append(Integer.valueOf(5));
                deque.prepend(Integer.valueOf(2));
                Integer expectedResult = 5;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is 2")
            void sizeIsOne() {
                deque.append(Integer.valueOf(5));
                deque.prepend(Integer.valueOf(2));
                Integer expectedResult = 2;
                Integer actualResult = deque.size();
                assertEquals(expectedResult, actualResult);
            }
        }


        @Nested
        @DisplayName("Appending 2 to a deque that contains 5")
        class appendOneElementToDequeThatContainsOneElement {
            @Test
            @DisplayName("First element is 5")
            void firstElementOfDequeIsFive() {
                deque.append(Integer.valueOf(5));
                deque.append(Integer.valueOf(2));
                Integer expectedResult = 5;
                Integer actualResult = deque.first();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Last element is 2")
            void lastElementIsFive() {
                deque.append(Integer.valueOf(5));
                deque.append(Integer.valueOf(2));
                Integer expectedResult = 2;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is 2")
            void sizeIsOne() {
                deque.append(Integer.valueOf(5));
                deque.append(Integer.valueOf(2));
                Integer expectedResult = 2;
                Integer actualResult = deque.size();
                assertEquals(expectedResult, actualResult);
            }
        }


        @Nested
        @DisplayName("Deleting first element from a deque that contains only the element 5")
        class deletingFirstElementFromDequeThatContainsOneElement {
            @Test
            @DisplayName("First throws exception")
            void firstElementIsNull() {
                deque.append(Integer.valueOf(5));
                deque.deleteFirst();
                assertThrows(DoubleEndedQueueException.class, () -> deque.first());
            }

            @Test
            @DisplayName("Last throws exception")
            void lastElementIsFive() {
                deque.append(Integer.valueOf(5));
                deque.deleteFirst();
                assertThrows(DoubleEndedQueueException.class, () -> deque.last());
            }

            @Test
            @DisplayName("Size is 0")
            void sizeIsOne() {
                deque.append(Integer.valueOf(5));
                deque.deleteFirst();
                Integer expectedResult = 0;
                Integer actualResult = deque.size();
                assertEquals(expectedResult, actualResult);
            }
        }


        @Nested
        @DisplayName("Deleting first element from a deque that contains the elements 5 and 2")
        class deletingFirstElementFromDequeThatContainsTwoElements {
            @Test
            @DisplayName("First is 2")
            void firstElementIsTwo() {
                deque.append(Integer.valueOf(5));
                deque.append(Integer.valueOf(2));
                deque.deleteFirst();
                Integer expectedResult = 2;
                Integer actualResult = deque.first();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Last element is 2")
            void lastElementIsFive() {
                deque.append(Integer.valueOf(5));
                deque.append(Integer.valueOf(2));
                deque.deleteFirst();
                Integer expectedResult = 2;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is 1")
            void sizeIsOne() {
                deque.append(Integer.valueOf(5));
                deque.append(Integer.valueOf(2));
                deque.deleteFirst();
                Integer expectedResult = 1;
                Integer actualResult = deque.size();
                assertEquals(expectedResult, actualResult);
            }
        }


        @Nested
        @DisplayName("Deleting last element from a deque that contains the elements 5 and 2")
        class deletingLastElementFromDequeThatContainsTwoElements {
            @Test
            @DisplayName("First is 5")
            void firstElementIsTwo() {
                deque.append(Integer.valueOf(5));
                deque.append(Integer.valueOf(2));
                deque.deleteLast();
                Integer expectedResult = 5;
                Integer actualResult = deque.first();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Last element is 5")
            void lastElementIsFive() {
                deque.append(Integer.valueOf(5));
                deque.append(Integer.valueOf(2));
                deque.deleteLast();
                Integer expectedResult = 5;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is 1")
            void sizeIsOne() {
                deque.append(Integer.valueOf(5));
                deque.append(Integer.valueOf(2));
                deque.deleteLast();
                Integer expectedResult = 1;
                Integer actualResult = deque.size();
                assertEquals(expectedResult, actualResult);
            }
        }
    }
}