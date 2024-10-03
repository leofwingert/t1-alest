
public class LinkedStack implements StackTAD {
    SinglyLinkedList pilha = new SinglyLinkedList();

    @Override
    public void push(int element) {
        pilha.add(0,element);
    }

    @Override
    public int pop() {
        return pilha.removeFirst();
    }

    @Override
    public int size() {
        return pilha.size();
    }

    @Override
    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    @Override
    public void clear() {
        pilha.clear();
    }

    @Override
    public int top() {
        return pilha.get(0);
    }
}
