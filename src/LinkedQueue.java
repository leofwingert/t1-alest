
public class LinkedQueue implements QueueTAD {
    DoublyLinkedList queue = new DoublyLinkedList();

    @Override
    public void enqueue(int element) {
        queue.add(element);
    }

    @Override
    public int dequeue() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int head() {
        return 0;
    }
}
