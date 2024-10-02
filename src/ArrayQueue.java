
public class ArrayQueue implements QueueTAD {
    int front, rear, tamanho, capacidade;
    int[] fila;

    public ArrayQueue() {
        front = 0;
        rear = -1;
        capacidade = 8;
        tamanho = 0;
        fila = new int[capacidade];
    }

    @Override
    public void enqueue(int element) {

        if (tamanho == capacidade){
            expandirQueue();
        }

        rear = (rear + 1) % capacidade;
        fila[rear] = element;
        tamanho++;

    }

    @Override
    public int dequeue() {
        int valor = fila[front];
        front = (front + 1) % capacidade;
        tamanho--;
        return valor;
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public boolean isEmpty() {
        return tamanho==0;
    }

    @Override
    public void clear() {
        front = 0;
        rear = -1;
        tamanho = 0;
    }

    @Override
    public int head() {
        return fila[front];
    }

    private void expandirQueue() {
        int novaCapacidade = capacidade + 2;
        int[] novaQueue = new int[novaCapacidade];

        for (int i = 0; i < tamanho; i++) {
            novaQueue[i] = fila[(front + i) % capacidade];
        }

        fila = novaQueue;
        capacidade = novaCapacidade;
        front = 0;
        rear = tamanho - 1;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
           sb.append("[").append(fila[i]).append("]");
        }
        return sb.toString();
    }

}
