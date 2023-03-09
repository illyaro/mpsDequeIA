package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Aryan Dilip Sadhwani Sadhwani
 * @author Illya Rozumovskyy
 */

/*
DEQUE NODE: TEST CASES
1. Single Node:
    a. Single node returns it's item when getItem is called
    b. Single node returns null when next is called
    c. Single node returns null when previous is called
    d. Single node is the first node
    e. Single node is the last node
    f. Single node is a terminal node
2. For prepended node:
    a. Prepended node is the first node
    b. Prepended node is NOT the last node
    c. Prepended node is NOT a terminal node
    d. The next node of prepended node is the first node
    e. The previous node of prepended node is null
3. For appended node:
    a. Appended node is the last node
    b. Appended node is NOT the first node
    c. Appended node is NOT a terminal node
    d. The previous node of appended node is the last node
    e. The next node of appended node is null
 */

@DisplayName("Double Linked List: node test")
class DequeNodeTest {

    protected DequeNode<Integer> firstNode;

    @BeforeEach
    void setUp() {
        this.firstNode = new DequeNode<>(Integer.valueOf(0), null, null);
    }

    @AfterEach
    void tearDown() {
        this.firstNode = null;
    }

    @Nested
    @DisplayName("A single Node")
    class singleNode {

        @Test
        @DisplayName("returns a it's Item when getItem is called")
        void singleNodeHasItem() {
            Integer expectedValue = Integer.valueOf(3);
            firstNode.setItem(expectedValue);
            Integer actualValue = firstNode.getItem();
            assertEquals(expectedValue, actualValue);
        }

        @Test
        @DisplayName("returns a null when next is called")
        void singlesNodeNextReturnsANull(){
            DequeNode<Integer> actualValue = firstNode.getNext();
            assertNull(actualValue);
        }

        @Test
        @DisplayName("returns a null when previous is called")
        void singlesNodePreviousReturnsANull(){
            DequeNode<Integer> actualValue = firstNode.getPrevious();
            assertNull(actualValue);
        }

        @Test
        @DisplayName("is the first node")
        void singleNodeIsTheFirstNode(){
            Boolean actualValue = firstNode.isFirstNode();
            assertTrue(actualValue);
        }

        @Test
        @DisplayName("is the last node")
        void singleNodeIsTheLastNode(){
            Boolean actualValue = firstNode.isLastNode();
            assertTrue(actualValue);
        }
        @Test
        @DisplayName("is the terminal node")
        void singleNodeIsTheTerminalNode(){
            Boolean actualValue = firstNode.isNotATerminalNode();
            assertFalse(actualValue);
        }
    }

    @Nested
    @DisplayName("A prepended node")
    class PrependedNode{


        DequeNode prependNodeTo(DequeNode node){
            DequeNode<Integer> prependedNode = new DequeNode<>(4,null, node);
            node.setPrevious(prependedNode);
            return prependedNode;
        }

        @Test
        @DisplayName("is the first node")
        void prependedNodeIsFirstNode(){
            DequeNode<Integer> prepended = prependNodeTo(firstNode);
            Boolean actualValue = prepended.isFirstNode();
            assertTrue(actualValue);
        }

        @Test
        @DisplayName("is not the last node")
        void prependedNodeIsNotLastNode(){
            DequeNode<Integer> prepended = prependNodeTo(firstNode);
            Boolean actualValue = prepended.isLastNode();
            assertFalse(actualValue);
        }

        @Test
        @DisplayName("is not the terminal node")
        void prependedNodeIsNotTerminalNode(){
            DequeNode<Integer> prepended = prependNodeTo(firstNode);
            Boolean actualValue = prepended.isNotATerminalNode();
            assertFalse(actualValue);
        }

        @Test
        @DisplayName("return the next node when getNext() is called")
        void prependedNodeReturnsAFirstNodeWhenNextIsCalled(){
            DequeNode<Integer> prepended = prependNodeTo(firstNode);
            DequeNode<Integer> expectedNode = firstNode;
            DequeNode<Integer> actualNode = prepended.getNext();
            assertEquals(expectedNode,actualNode);
        }

        @Test
        @DisplayName("returns null when getPrevious is called")
        void prependedNodeReturnsNullWhenPreviousIsCalled(){
            DequeNode<Integer> prepended = prependNodeTo(firstNode);
            DequeNode<Integer> actualNode = prepended.getPrevious();
            assertNull(actualNode);
        }
    }

    @Nested
    @DisplayName("An appended node")
    class AppendedNode{
        DequeNode appendNodeAfter(DequeNode node){
            DequeNode<Integer> appendedNode = new DequeNode<>(4, node, null);
            node.setNext(appendedNode);
            return appendedNode;
        }

        @Test
        @DisplayName("is the last node")
        void appendedNodeIsLastNode(){
            DequeNode<Integer> appended = appendNodeAfter(firstNode);
            Boolean actualValue = appended.isLastNode();
            assertTrue(actualValue);
        }

        @Test
        @DisplayName("is not the first node")
        void appendedNodeIsNotFirstNode(){
            DequeNode<Integer> appended = appendNodeAfter(firstNode);
            Boolean actualValue = appended.isFirstNode();
            assertFalse(actualValue);
        }

        @Test
        @DisplayName("is not the terminal node")
        void appendedNodeIsNotTerminalNode(){
            DequeNode<Integer> appended = appendNodeAfter(firstNode);
            Boolean actualValue = appended.isNotATerminalNode();
            assertFalse(actualValue);
        }

        @Test
        @DisplayName("return the previous node when getPrevious() is called")
        void appendedNodeReturnsALastNodeWhenPreviousIsCalled(){
            DequeNode<Integer> appended = appendNodeAfter(firstNode);
            DequeNode<Integer> expectedNode = firstNode;
            DequeNode<Integer> actualNode = appended.getPrevious();
            assertEquals(expectedNode,actualNode);
        }

        @Test
        @DisplayName("returns null when getNext() is called")
        void appendedNodeReturnsNullWhenNextIsCalled(){
            DequeNode<Integer> appended = appendNodeAfter(firstNode);
            DequeNode<Integer> actualNode = appended.getNext();
            assertNull(actualNode);
        }
    }

    @Nested
    @DisplayName("A middle node")
    class MiddleNode{

        @Test
        @DisplayName("is not a terminal node")
        void middleNodeIsNotATerminalNode(){
            DequeNode<Integer> prepended = new DequeNode<>(4, null, firstNode);
            DequeNode<Integer> appended = new DequeNode<>(4, firstNode, null);
            firstNode.setPrevious(prepended);
            firstNode.setNext(appended);
            Boolean actualValue = firstNode.isNotATerminalNode();
            assertTrue(actualValue);
        }

    }

}