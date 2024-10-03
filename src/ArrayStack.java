public class ArrayStack implements StackTAD {
    private int[] stack;
    private int size;

    // Tamanho inicial padrão
    private static final int INITIAL_CAPACITY = 8;

    // Construtor
    public ArrayStack() {
        stack = new int[INITIAL_CAPACITY];
        size = 0;
    }

    // Aumenta o tamanho do array se necessário
    private void ensureCapacity() {
        if (size == stack.length) {
            int[] newStack = new int[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
    }

    // Adiciona elemento no topo da pilha
    @Override
    public void push(int element) {
        ensureCapacity();
        stack[size] = element;
        size++;
    }

    // Remove o elemento do topo da pilha
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia.");
        }
        int topElement = stack[size - 1];
        size--;
        return topElement;
    }

    // Retorna o tamanho da pilha
    @Override
    public int size() {
        return size;
    }

    // Verifica se a pilha está vazia
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Remove todos os elementos da pilha
    @Override
    public void clear() {
        size = 0;
    }

    // Retorna o elemento do topo da pilha, sem removê-lo
    @Override
    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia.");
        }
        return stack[size - 1];
    }

    // Método para mostrar o conteúdo da pilha (opcional, útil para debug)
    public void printStack() {
        System.out.print("Stack: ");
        for (int i = 0; i < size; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}