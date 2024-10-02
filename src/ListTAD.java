// Interface ListTAD:
// Define os métodos que qualquer implementação
// de lista deve ter
// (isto é, eles PRECISAM ser implementados)
//
public interface ListTAD {

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(int element);

    /**
     * Adiciona um elemento em um índice específico da lista.
     * @param index índice em que o elemento deve ser adicionado.
     * @param element elemento a ser adicionado ao final da lista.
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, int element);

    /**
     * Adiciona um elemento na primeira posição da lista.
     * @param element elemento a ser adicionado  da lista.
     */
    public void addFirst(int e);

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int get(int index);

    /**
     * Retorna o elemento na primeira posição da lista.
     * @return o elemento da primeira posição.
     */
    public int getFirst();

    /**
     * Retorna o elemento na última posição da lista.
     * @return o elemento da última posição.
     */
    public int getLast();

    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * @param index   a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int set(int index, int element);

    /**
     * Procura e remove da lista o primeiro elemento com valor passado como parâmetro.
     * @param element o elemento a ser removido.
     * @return true caso tenha sido removido, false caso não tenha removido.
     */
    public boolean remove(int element);

    /**
     * Remove da lista o elemento no índice passado como parâmetro.
     * @param index o índice do elemento a ser removido
     * @return o elemento removido
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int removeByIndex(int index);

    /**
     * Remove o elemento no na primeira posição da lista.
     * @return o elemento removido
     */
    public int removeFirst();

    /**
     * Remove o elemento no na última posição da lista.
     * @return o elemento removido
     */
    public int removeLast();

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty();

    /**
     * Procura pelo elemento passado por parâmetro na lista e retorna true se a 
	 * lista contém este elemento.
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */
    public boolean contains(int element);

    /**
     * Retorna a posição na qual está armazenado o valor passado por parâmetro.
     * @param element O elemento a ser procurado
     * @return A posição do elemento na lista ou -1 caso não esteja na lista.
     */
    public int indexOf(int element);

    /**
     * Retorna o numero de elementos armazenados na lista.
     * @return o numero de elementos da lista
     */
    public int size();

    /**
     * Esvazia a lista.
     */
    public void clear();
}
