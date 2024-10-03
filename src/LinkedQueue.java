
public class LinkedQueue implements QueueTAD {
    SinglyLinkedList queue = new SinglyLinkedList();

    @Override
    public void enqueue(int element) {
        queue.add(element);
    }

    @Override
    public int dequeue() {
        int x = queue.get(0);
        queue.removeFirst();
        return x;
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public int head() {
        return queue.get(0);
    }
}
