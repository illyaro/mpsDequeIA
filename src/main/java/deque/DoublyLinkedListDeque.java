package deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        // TODO
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        // TODO
        if(first == null) {
            DequeNode<T> node = new DequeNode<>(value, null, null);
            first = node;
        } else {
            DequeNode<T> node = new DequeNode<>(value, null, first);
            first = node;
        }
        size++;

    }

    @Override
    public void append(T value) {
        // TODO
        if(last == null) {
            DequeNode<T> node = new DequeNode<>(value, null, null);
            last = node;
            first = node;
        } else {
            DequeNode<T> node = new DequeNode<>(value, last, null);
            last = node;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if(first == null) {
            throw new DoubleEndedQueueException("ERROR: Queue is empty.");
        } else {
            first = first.getNext();
            size--;
            if(size == 0) {
                last = null;
            }
        }
    }

    @Override
    public void deleteLast() {
        // TODO
        if(last == null) {
            throw new DoubleEndedQueueException("ERROR: Queue is empty.");
        } else {
            last = last.getPrevious();
            size--;
            if(size == 0) {
                first = null;
            }
        }
    }

    @Override
    public T first() {
        // TODO
        if(first == null) {
            throw new DoubleEndedQueueException("ERROR: Queue is empty.");
        }
        return this.first.getItem();
    }

    @Override
    public T last() {
        // TODO
        if(last == null) {
            throw new DoubleEndedQueueException("ERROR: Queue is empty.");
        }
        return this.last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return this.size;
    }
}
