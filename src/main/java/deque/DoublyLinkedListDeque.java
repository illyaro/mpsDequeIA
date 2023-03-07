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
        if(size == 0) {
            // TODO Create a node because rn is null
            first.setItem(value);
        } else {
            DequeNode<T> next = new DequeNode<>(value, null, first);
            first = next;
        }
        size++;

    }

    @Override
    public void append(T value) {
        // TODO
        if(size == 0) {
            first.setItem(value);
        } else {
            DequeNode<T> next = new DequeNode<>(value, last, null);
            last = next;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if(size == 0) {
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
        if(size == 0) {
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
        if(this.first == null) {
            throw new DoubleEndedQueueException("ERROR: Queue is empty.");
        }
        return this.first.getItem();
    }

    @Override
    public T last() {
        // TODO
        if(this.last == null) {
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
