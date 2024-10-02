public interface StackTAD {

    /**
     * Adiciona elemento no topo da pilha.
     * @param element
     */
    public void push(int element);

    /**
     * Remove o elemento do topo da pilha.
     * @return O elemento que se encontrava no topo da pilha.
     */
    public int pop();

    /**
     * @return O tamanho da pilha.
     */
    public int size();

    /**
     * @return true se a pilha estiver vazia, false caso contrário.
     */
    public boolean isEmpty();

    /**
     * Remove todos elementos da pilha.
     */
    public void clear();

    /**
     * Retorna o elemento do topo da pilha, sem removê-lo.
     * @return O elemento presente no topo da pilha.
     */
    public int top();
}



