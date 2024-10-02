
public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue);

        System.out.println("Tamanho da fila: " + queue.size());
        System.out.println("Retirando um valor: " + queue.dequeue());
        System.out.println("Tamanho da fila: " + queue.size());

    }

}
