package org.mps.deque;

import org.junit.jupiter.api.*;

import java.util.Comparator;
import java.util.Deque;

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

DeleteLast() of Deque containing 5: first() throws exception;
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
                deque.prepend(5);
                Integer expectedResult = 5;
                Integer actualResult = deque.first();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Last element is 5")
            void lastElementIsFive() {
                deque.prepend(5);
                Integer expectedResult = 5;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is 1")
            void sizeIsOne() {
                deque.prepend(5);
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
                deque.append(5);
                Integer expectedResult = 5;
                Integer actualResult = deque.first();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Last element is 5")
            void lastElementIsFive() {
                deque.append(5);
                Integer expectedResult = 5;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is 1")
            void sizeIsOne() {
                deque.append(5);
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
                deque.append(5);
                deque.prepend(2);
                Integer expectedResult = 2;
                Integer actualResult = deque.first();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Last element is 5")
            void lastElementIsFive() {
                deque.append(5);
                deque.prepend(2);
                Integer expectedResult = 5;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is 2")
            void sizeIsOne() {
                deque.append(5);
                deque.prepend(2);
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
                deque.append(5);
                deque.append(2);
                Integer expectedResult = 5;
                Integer actualResult = deque.first();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Last element is 2")
            void lastElementIsFive() {
                deque.append(5);
                deque.append(2);
                Integer expectedResult = 2;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is 2")
            void sizeIsOne() {
                deque.append(5);
                deque.append(2);
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
                deque.append(5);
                deque.deleteFirst();
                assertThrows(DoubleEndedQueueException.class, () -> deque.first());
            }

            @Test
            @DisplayName("Last throws exception")
            void lastElementIsFive() {
                deque.append(5);
                deque.deleteFirst();
                assertThrows(DoubleEndedQueueException.class, () -> deque.last());
            }

            @Test
            @DisplayName("Size is 0")
            void sizeIsOne() {
                deque.append(5);
                deque.deleteFirst();
                Integer expectedResult = 0;
                Integer actualResult = deque.size();
                assertEquals(expectedResult, actualResult);
            }
        }

        @Nested
        @DisplayName("Deleting last element from a deque that contains only the element 5")
        class deletingLastElementFromDequeThatContainsOneElement {
            @Test
            @DisplayName("First throws exception")
            void firstElementIsNull() {
                deque.append(5);
                deque.deleteLast();
                assertThrows(DoubleEndedQueueException.class, () -> deque.first());
            }

            @Test
            @DisplayName("Last throws exception")
            void lastElementIsFive() {
                deque.append(5);
                deque.deleteLast();
                assertThrows(DoubleEndedQueueException.class, () -> deque.last());
            }

            @Test
            @DisplayName("Size is 0")
            void sizeIsOne() {
                deque.append(5);
                deque.deleteLast();
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
                deque.append(5);
                deque.append(2);
                deque.deleteFirst();
                Integer expectedResult = 2;
                Integer actualResult = deque.first();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Last element is 2")
            void lastElementIsFive() {
                deque.append(5);
                deque.append(2);
                deque.deleteFirst();
                Integer expectedResult = 2;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is 1")
            void sizeIsOne() {
                deque.append(5);
                deque.append(2);
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
                deque.append(5);
                deque.append(2);
                deque.deleteLast();
                Integer expectedResult = 5;
                Integer actualResult = deque.first();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Last element is 5")
            void lastElementIsFive() {
                deque.append(5);
                deque.append(2);
                deque.deleteLast();
                Integer expectedResult = 5;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is 1")
            void sizeIsOne() {
                deque.append(5);
                deque.append(2);
                deque.deleteLast();
                Integer expectedResult = 1;
                Integer actualResult = deque.size();
                assertEquals(expectedResult, actualResult);
            }
        }
    }

    @Nested
    @DisplayName("get tests")
    class getTests {

        @Test
        @DisplayName("negative index throws exception.")
        void negativeIndexThrowsException() {
            int index = -1;
            assertThrows(IndexOutOfBoundsException.class, () -> deque.get(index));
        }

        @Test
        @DisplayName("index greater than size throws exception.")
        void sizeIndexThrowsException() {
            deque.append(1);
            int index = 2;
            assertThrows(IndexOutOfBoundsException.class, () -> deque.get(index));
        }

        @Test
        @DisplayName("index 0 returns first element")
        void indexZeroReturnsFirstElement() {
            deque.append(1);
            int index = 0;
            Integer expectedResult = 1;
            Integer actualResult = deque.get(index);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("index 1 returns second element")
        void indexOneReturnsSecondElementInDequeWithThreeElements() {
            deque.append(1);
            deque.append(2);
            deque.append(3);
            int index = 1;
            Integer expectedResult = 2;
            Integer actualResult = deque.get(index);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("index size()-1 returns last element")
        void lastIndexReturnsLastElementInDequeWithThreeElements() {
            deque.append(1);
            deque.append(2);
            deque.append(3);
            int index = deque.size() - 1;
            Integer expectedResult = 3;
            Integer actualResult = deque.get(index);
            assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    @DisplayName("contains tests")
    class containsTest {
        @Test
        @DisplayName("empty deque always returns false")
        void emptyDequeReturnsFalseForAnyElement(){
            Integer value = 2;
            boolean expectedResult = false;
            boolean actualResult = deque.contains(value);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("return false if doesnt contain element.")
        void dequeReturnsFalseIfDoesntContainElement(){
            Integer value = 2;
            deque.append(1);
            boolean expectedResult = false;
            boolean actualResult = deque.contains(value);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("return true if it contains the element.")
        void dequeReturnsTrueIfContainsElement(){
            Integer value = 2;
            deque.append(2);
            boolean expectedResult = true;
            boolean actualResult = deque.contains(value);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("return true if it contains the element.")
        void dequeOfSize2ReturnsTrueIfContainsElement(){
            Integer value = 4;
            deque.append(2);
            deque.append(4);
            boolean expectedResult = true;
            boolean actualResult = deque.contains(value);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("return false if it doesnt contains the element.")
        void dequeOfSize2ReturnsFalseIfDoesntContainsElement(){
            Integer value = 5;
            deque.append(2);
            deque.append(4);
            boolean expectedResult = false;
            boolean actualResult = deque.contains(value);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("Null object does not exist in the Deque")
        void nullDoesNonExist(){
            Integer value = null;
            deque.append(2);
            deque.append(4);
            boolean expectedResult = false;
            boolean actualResult = deque.contains(value);
            assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    @DisplayName("Remove method")
    class remove {

        @Test
        @DisplayName("Does nothing when deque is empty")
        void doesNothingWhenDequeIsEmpty(){
            int expectedResult = 0;
            deque.remove(4);
            int actualResult = deque.size();
            assertEquals(expectedResult,actualResult);
        }

        @Test
        @DisplayName("Does nothing when element is not exist")
        void doesNothingWhenElementIsNotExist(){
            deque.append(4);
            deque.append(5);
            int expectedResult = deque.size();
            deque.remove(1);
            int actualResult = deque.size();
            assertEquals(expectedResult, actualResult);
        }

        @Test
        @DisplayName("Removes the single element and makes deque empty")
        void RemovesTheSingleElementAndMakesDequeEmpty(){
            deque.append(5);
            deque.remove(5);
            assertAll(
                    () -> assertEquals(0, deque.size()),
                    () -> assertThrows(DoubleEndedQueueException.class ,() -> deque.first()),
                    () -> assertThrows(DoubleEndedQueueException.class ,() -> deque.last())
            );
        }

        @Test
        @DisplayName("Removes the first element from the deque")
        void removesFirstElement(){
            deque.append(1);
            deque.append(2);
            deque.remove(1);
            Integer expectedResult = 2;
            Integer actualResult = deque.first();
            assertEquals(expectedResult, actualResult);
        }
    }

    @Nested
    @DisplayName("Sort method")
    class sort {

        @Test
        @DisplayName("sort empty deque returns empty deque.")
        void sortEmptyDequeReturnsEmpty() {
            int expectedSize = 0;
            deque.sort(Comparator.naturalOrder());
            int actualSize = deque.size();
            assertEquals(expectedSize, actualSize);
        }

        @Test
        @DisplayName("sort deque with one element.")
        void sortDequeWithOneElement() {
            int expectedSize = 1;
            deque.append(2);
            deque.sort(Comparator.naturalOrder());
            int actualSize = deque.size();
            assertAll(
                    () -> assertEquals(expectedSize, actualSize),
                    () -> assertEquals(2, deque.first()),
                    () -> assertEquals(2, deque.last())
            );
        }


        @Test
        @DisplayName("sort deque with two elements.")
        void sortDequeWithTwoElements() {
            int expectedSize = 2;
            deque.append(2);
            deque.append(1);
            deque.sort(Comparator.naturalOrder());
            int actualSize = deque.size();
            assertAll(
                    () -> assertEquals(expectedSize, actualSize),
                    () -> assertEquals(1, deque.first()),
                    () -> assertEquals(2, deque.last())
            );
        }

        @Test
        @DisplayName("sort deque with two elements.")
        void sortDequeWithTwoOrderedElements() {
            int expectedSize = 2;
            deque.append(1);
            deque.append(2);
            deque.sort(Comparator.naturalOrder());
            int actualSize = deque.size();
            assertAll(
                    () -> assertEquals(expectedSize, actualSize),
                    () -> assertEquals(1, deque.first()),
                    () -> assertEquals(2, deque.last())
            );
        }

        @Test
        @DisplayName("sort deque with three elements.")
        void sortDequeWithThreeElements() {
            int expectedSize = 3;
            deque.append(2);
            deque.append(3);
            deque.append(1);
            deque.sort(Comparator.naturalOrder());
            int actualSize = deque.size();
            assertAll(
                    () -> assertEquals(expectedSize, actualSize),
                    () -> assertEquals(1, deque.first()),
                    () -> assertEquals(3, deque.last())
            );
        }

        @Test
        @DisplayName("sort deque with three ordered elements.")
        void sortDequeWithThreeSortedElements() {
            int expectedSize = 3;
            deque.append(1);
            deque.append(2);
            deque.append(3);
            deque.sort(Comparator.naturalOrder());
            int actualSize = deque.size();
            assertAll(
                    () -> assertEquals(expectedSize, actualSize),
                    () -> assertEquals(1, deque.first()),
                    () -> assertEquals(3, deque.last())
            );
        }

    }
}