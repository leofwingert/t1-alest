public interface QueueTAD {
    
    /**
     * Adiciona um elemento no final da fila.
     * @param element
     */
    public void enqueue(int element);

    /**
     * Remove o elemento no início da fila e retorna ele.
     * @return O elemento que estava no início da fila.
     */
    public int dequeue();

    /**
     * @return O tamanho da fila.
     */
    public int size();

    /**
     * @return true se a fila estiver vazia, false caso contrário.
     */
    public boolean isEmpty();

    /**
     * Remove todos elementos da fila.
     */
    public void clear();

    /**
     * Retorna o elemento no início da fila, sem removê-lo.
     * @return O primeiro elemento da fila.
     */
    public int head();
}
