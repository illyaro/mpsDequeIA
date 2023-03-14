package org.mps.deque;

import java.util.Comparator;

/**
 * @author Illya Rozumovskyy
 * @author Aryan Dilip Sadhwani Sadhwani
 */

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        if (first == null) {
            DequeNode<T> node = new DequeNode<>(value, null, null);
            first = node;
            last = node;
        } else {
            DequeNode<T> node = new DequeNode<>(value, null, first);
            first.setPrevious(node);
            first = node;
        }
        size++;

    }

    @Override
    public void append(T value) {
        if (last == null) {
            DequeNode<T> node = new DequeNode<>(value, null, null);
            last = node;
            first = node;
        } else {
            DequeNode<T> node = new DequeNode<>(value, last, null);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if (first == null) {
            throw new DoubleEndedQueueException("ERROR: Queue is empty.");
        } else {
            first = first.getNext();
            size--;
            if (size == 0) {
                last = null;
            }
        }
    }

    @Override
    public void deleteLast() {
        if (last == null) {
            throw new DoubleEndedQueueException("ERROR: Queue is empty.");
        } else {
            last = last.getPrevious();
            size--;
            if (size == 0) {
                first = null;
            }
        }
    }

    @Override
    public T first() {
        if (first == null) {
            throw new DoubleEndedQueueException("ERROR: Queue is empty.");
        }
        return this.first.getItem();
    }

    @Override
    public T last() {
        if (last == null) {
            throw new DoubleEndedQueueException("ERROR: Queue is empty.");
        }
        return this.last.getItem();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Index is invalid.");
        } else {
            DequeNode<T> node = this.first;
            int i = 0;
            while(i < index) {
                i++;
                node = node.getNext();
            }
            return node.getItem();
        }
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        int index = 0;
        DequeNode<T> node = this.first;
        while(!contains && index < this.size()) {
            if(node.getItem().equals(value)) {
                contains = true;
            } else {
                node = node.getNext();
            }
            index++;
        }
        return contains;
    }

    @Override
    public void remove(T value) {
        for(int i = 0; i< size; i++){
            DequeNode<T> prev = null;
            DequeNode<T> current = first;
            if(current.getItem().equals(value)){
                prev.setNext(current.getNext());
                current = prev;
                break;
            }
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        for(int i = 0; i < size; i++) {
            DequeNode<T> current = first;
            DequeNode<T> next = first.getNext();
            for(int j = 0; j < size - 1; j++) {
                if(comparator.compare(current.getItem(), next.getItem()) > 0) {
                    T temp = current.getItem();
                    current.setItem(next.getItem());
                    next.setItem(temp);
                }
                current = current.getNext();
                next = next.getNext();
            }
        }
    }
}

