package org.mps.deque;

import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Aryan Dilip Sadhwani Sadhwani
 * @author Illya Rozumovskyy
 */

/*
Double Linked List Deque Test Cases:
1. With empty Deque:
    a. size() returns 0.
    b. first() throws DoubleEndedQueueException exception.
    c. last() throws DoubleEndedQueueException exception.
    d. DeleteFirst() throws DoubleEndedQueueException exception.
    e. DeleteLast() throws DoubleEndedQueueException exception.
        i. Exception message is correct for first() method when Deque is empty.
        ii. Exception message is correct for last() method when Deque is empty.
        iii. Exception message is correct for DeleteFirst() when Deque is empty.
        iv. Exception message is correct for DeleteLast() when Deque is empty.
2. With Valid Deque:
    a. Prepend 5 to empty Deque : first() returns 5;
                                  last() returns 5;
                                  size() returns 1.
    b. Append 5 to empty Deque : first() returns 5;
                                 last() returns 5;
                                 size() returns 1.
    c. Prepend 2 to Deque containing 5 : first() returns 2;
                                         last() returns 5;
                                         size() returns 2.
    d. Append 2 to Deque containing 5 : first() returns 5;
                                        last() returns 2;
                                        size() returns 2.
    e. DeleteFirst() of Deque containing 5: first() throws exception;
                                            last() throws exception;
                                            size() returns 0.
    f. DeleteLast() of Deque containing 5: first() throws exception;
                                           last() throws exception;
                                           size() returns 0.
    g. DeleteFirst() of Deque containing 5 and 2: first() returns 2;
                                                  last() returns 2;
                                                  size() returns 1.
    h. DeleteLast() of Deque containing 5 and 2: first() returns 5;
                                                 last() returns 5;
                                                 size() returns 1.
3. Advanced Deque operations:
    a. get() element by index method:
        i. Throws an IndexOutOfBoundsException exception when negative index is passed.
        ii. Throws an IndexOutOfBoundsException exception when index is greater than size of Deque.
        iii. Returns the fist element when index is 0.
        iv. Returns the second element when index is 1.
        v. Returns the last element when index is size of Deque - 1.
    b. contains() an element method:
        i. Returns false for any element when Deque is empty.
        ii. Returns false when Deque of size 1 does not contain the element.
        iii. Returns true when Deque of size 1 contains the element.
        iv. Returns true when Deque of size 2 contain the element.
        v. Returns false when Deque of size 2 does not contain the element.
        vi. Returns false when null is passed.
    c. remove() an element method:
        i. Does nothing when deque is empty.
        ii. Does nothing when element is not present in Deque.
        iii. Removes the single element from Deque is of size 1 and:    first() throws exception;
                                                                        last() throws exception;
                                                                        size() returns 0.
        iv. Finds and removes the first element from Deque that has 1 & 2 and:  first() returns 2;
                                                                                last() returns 2;
                                                                                size() returns 1.
        v. Finds and removes the last element from Deque that has 1 & 2 and:   first() returns 1;
                                                                                last() returns 1;
                                                                                size() returns 1.
        vi. Finds and removes the middle element from Deque that has 1, 2 & 3 and:  first() returns 1;
                                                                                    last() returns 3;
                                                                                    size() returns 2.

    d. sort() method:
        i. Return an empty Deque when Deque is empty.
        ii. Return the same Deque of size 1 when applied to Deque is of size 1.
        iii. Returns a sorted Deque of size 2 when applied to unsorted Deque is of size 2.
        iv. Returns a sorted Deque of size 2 when applied to sorted Deque is of size 2.
        v. Returns a sorted Deque of size 3 when applied to unsorted Deque is of size 3.
        vi. Returns a sorted Deque of size 3 when applied to sorted Deque is of size 3.
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

        @Test
        @DisplayName("Exception is thrown when delete first is called")
        void emptyDequeThrowsAnExceptionWhenDeleteFirstIsCalled() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
        }

        @Test
        @DisplayName("Exception is thrown when delete last is called")
        void emptyDequeThrowsAnExceptionWhenDeleteLastIsCalled() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
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
    @DisplayName("Basic operations with valid deque which size is greater than zero")
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
            void firstMethodThrowsException() {
                deque.append(5);
                deque.deleteFirst();
                assertThrows(DoubleEndedQueueException.class, () -> deque.first());
            }

            @Test
            @DisplayName("Last throws exception")
            void lastMethodThrowsException() {
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
            void firstMethodThrowsException() {
                deque.append(5);
                deque.deleteLast();
                assertThrows(DoubleEndedQueueException.class, () -> deque.first());
            }

            @Test
            @DisplayName("Last throws exception")
            void lastMethodThrowsException() {
                deque.append(5);
                deque.deleteLast();
                assertThrows(DoubleEndedQueueException.class, () -> deque.last());
            }

            @Test
            @DisplayName("Size is 0")
            void sizeIsZero() {
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
            void lastElementIsTwo() {
                deque.append(5);
                deque.append(2);
                deque.deleteFirst();
                Integer expectedResult = 2;
                Integer actualResult = deque.last();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("Size is One")
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
            void firstElementIsFive() {
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
    @DisplayName("Advanced Deque operations")
    class advancedDequeOperations {
        @Nested
        @DisplayName("with get() method")
        class getTests {

            @Test
            @DisplayName("negative index throws exception.")
            void negativeIndexThrowsException() {
                int index = -1;
                assertThrows(IndexOutOfBoundsException.class, () -> deque.get(index));
            }

            @Test
            @DisplayName("index greater than size throws exception.")
            void greaterThanSizeIndexThrowsException() {
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
        @DisplayName("with contains() method")
        class containsTest {
            @Test
            @DisplayName("returns false if deque is empty")
            void emptyDequeReturnsFalseForAnyElement() {
                Integer value = 2;
                boolean expectedResult = false;
                boolean actualResult = deque.contains(value);
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("return false if doesn't the contain element.")
            void dequeReturnsFalseIfDoesntContainElement() {
                Integer value = 2;
                deque.append(1);
                boolean expectedResult = false;
                boolean actualResult = deque.contains(value);
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("return true if deque of size 1 contains the element.")
            void dequeReturnsTrueIfContainsElement() {
                Integer value = 2;
                deque.append(2);
                boolean expectedResult = true;
                boolean actualResult = deque.contains(value);
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("return true if deque of size 2 contains the element.")
            void dequeOfSize2ReturnsTrueIfContainsElement() {
                Integer value = 4;
                deque.append(2);
                deque.append(4);
                boolean expectedResult = true;
                boolean actualResult = deque.contains(value);
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("return false if deque of size 2 doesn't contain the element.")
            void dequeOfSize2ReturnsFalseIfDoesntContainsElement() {
                Integer value = 5;
                deque.append(2);
                deque.append(4);
                boolean expectedResult = false;
                boolean actualResult = deque.contains(value);
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("null value returns false")
            void nullDoesNonExist() {
                Integer value = null;
                deque.append(2);
                deque.append(4);
                boolean expectedResult = false;
                boolean actualResult = deque.contains(value);
                assertEquals(expectedResult, actualResult);
            }
        }

        @Nested
        @DisplayName("with remove() method")
        class remove {

            @Test
            @DisplayName("Does nothing when deque is empty")
            void doesNothingWhenDequeIsEmpty() {
                int expectedResult = 0;
                deque.remove(4);
                int actualResult = deque.size();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("does nothing when element is not present in deque")
            void doesNothingWhenElementIsNotExist() {
                deque.append(4);
                deque.append(5);
                int expectedResult = deque.size();
                deque.remove(1);
                int actualResult = deque.size();
                assertEquals(expectedResult, actualResult);
            }

            @Test
            @DisplayName("returns empty deque when removing the only element in the deque")
            void RemovesTheSingleElementAndMakesDequeEmpty() {
                deque.append(5);
                deque.remove(5);
                assertAll(
                        () -> assertEquals(0, deque.size()),
                        () -> assertThrows(DoubleEndedQueueException.class, () -> deque.first()),
                        () -> assertThrows(DoubleEndedQueueException.class, () -> deque.last())
                );
            }

            @Test
            @DisplayName("removes the first element from deque that contains 2 elements")
            void removesFirstElement() {
                deque.append(1);
                deque.append(2);
                deque.remove(1);
                int expectedSize = 1;
                int actualSize = deque.size();
                Integer expectedFirst = 2;
                Integer actualFirst = deque.first();
                Integer expectedLast = 2;
                Integer actualLast = deque.last();
                assertAll(
                        () -> assertEquals(expectedSize, actualSize),
                        () -> assertEquals(expectedFirst, actualFirst),
                        () -> assertEquals(expectedLast, actualLast)
                );
            }

            @Test
            @DisplayName("removes the last element from deque that contains 2 elements")
            void removesLastElement() {
                deque.append(1);
                deque.append(2);
                deque.remove(2);
                int expectedSize = 1;
                int actualSize = deque.size();
                Integer expectedFirst = 1;
                Integer actualFirst = deque.first();
                Integer expectedLast = 1;
                Integer actualLast = deque.last();
                assertAll(
                        () -> assertEquals(expectedSize, actualSize),
                        () -> assertEquals(expectedFirst, actualFirst),
                        () -> assertEquals(expectedLast, actualLast)
                );
            }

            @Test
            @DisplayName("removes the middle element of a deque with 3 elements")
            void removesMiddleElement() {
                deque.append(1);
                deque.append(2);
                deque.append(3);
                deque.remove(2);
                int expectedSize = 2;
                int actualSize = deque.size();
                Integer expectedFirst = 1;
                Integer actualFirst = deque.first();
                Integer expectedLast = 3;
                Integer actualLast = deque.last();
                assertAll(
                        () -> assertEquals(expectedSize, actualSize),
                        () -> assertEquals(expectedFirst, actualFirst),
                        () -> assertEquals(expectedLast, actualLast)
                );
            }
        }

        @Nested
        @DisplayName("With sort() method")
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
            @DisplayName("sort deque with one element returns same deque.")
            void sortDequeWithOneElement() {
                int expectedSize = 1;
                deque.append(2);
                deque.sort(Comparator.naturalOrder());
                int actualSize = deque.size();
                Integer expectedFirst = 2;
                Integer actualFirst = deque.first();
                Integer expectedLast = 2;
                Integer actualLast = deque.last();
                assertAll(
                        () -> assertEquals(expectedSize, actualSize),
                        () -> assertEquals(expectedFirst, actualFirst),
                        () -> assertEquals(expectedLast, actualLast)
                );
            }


            @Test
            @DisplayName("sort deque with two elements returns ordered deque.")
            void sortDequeWithTwoElements() {
                int expectedSize = 2;
                deque.append(2);
                deque.append(1);
                deque.sort(Comparator.naturalOrder());
                int actualSize = deque.size();
                Integer expectedFirst = 1;
                Integer actualFirst = deque.first();
                Integer expectedLast = 2;
                Integer actualLast = deque.last();
                assertAll(
                        () -> assertEquals(expectedSize, actualSize),
                        () -> assertEquals(expectedFirst, actualFirst),
                        () -> assertEquals(expectedLast, actualLast)
                );
            }

            @Test
            @DisplayName("sort deque with two already ordered elements returns the same deque.")
            void sortDequeWithTwoOrderedElements() {
                int expectedSize = 2;
                deque.append(1);
                deque.append(2);
                deque.sort(Comparator.naturalOrder());
                int actualSize = deque.size();
                Integer expectedFirst = 1;
                Integer actualFirst = deque.first();
                Integer expectedLast = 2;
                Integer actualLast = deque.last();
                assertAll(
                        () -> assertEquals(expectedSize, actualSize),
                        () -> assertEquals(expectedFirst, actualFirst),
                        () -> assertEquals(expectedLast, actualLast)
                );
            }

            @Test
            @DisplayName("sort deque with three elements returns ordered deque.")
            void sortDequeWithThreeElements() {
                int expectedSize = 3;
                deque.append(2);
                deque.append(3);
                deque.append(1);
                deque.sort(Comparator.naturalOrder());
                int actualSize = deque.size();
                Integer expectedFirst = 1;
                Integer actualFirst = deque.first();
                Integer expectedLast = 3;
                Integer actualLast = deque.last();
                assertAll(
                        () -> assertEquals(expectedSize, actualSize),
                        () -> assertEquals(expectedFirst, actualFirst),
                        () -> assertEquals(expectedLast, actualLast)
                );
            }

            @Test
            @DisplayName("sort deque with three already ordered elements returns the same deque.")
            void sortDequeWithThreeSortedElements() {
                int expectedSize = 3;
                deque.append(1);
                deque.append(2);
                deque.append(3);
                deque.sort(Comparator.naturalOrder());
                int actualSize = deque.size();
                Integer expectedFirst = 1;
                Integer actualFirst = deque.first();
                Integer expectedLast = 3;
                Integer actualLast = deque.last();
                assertAll(
                        () -> assertEquals(expectedSize, actualSize),
                        () -> assertEquals(expectedFirst, actualFirst),
                        () -> assertEquals(expectedLast, actualLast)
                );
            }

        }
    }
}