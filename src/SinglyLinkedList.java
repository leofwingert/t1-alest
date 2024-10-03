public class SinglyLinkedList implements ListTAD
{
    private class Node
    {
        Integer element;
        Node next;

        public Node(Integer element)
        {
            this.element = element;
            this.next = null;
        }
    }
    Node head;
    Node tail;
    int count;

    public SinglyLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[ ");
        Node current = head;
        while(current != null)
        {
            sb.append(current.element).append(" ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void add(int element) {
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }

    @Override
    public void add(int index, int element) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException();

        // Cria o nodo
        Node n = new Node(element);

        // Encadear o nodo na lista
        if (index == 0) { // se insercao no inicio
            if (count == 0) { // se a lista estava vazia
                tail = n;
            }
            else {
                n.next = head;
            }
            head = n;
        }
        else if (index == count) { // se insercao no fiim
            tail.next = n;
            tail = n;
        }
        else { // se insercao no meio
            Node ant = head;
            for (int i=0; i<index-1; i++) {
                ant = ant.next;
            }
            n.next = ant.next;
            ant.next = n;
        }

        // Atualiza o count
        count++;
    }

    @Override
    public void addFirst(int e) {

    }

    @Override
    public int get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count-1)
            return tail.element;

        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return aux.element;
    }

    @Override
    public int getFirst() {
        return 0;
    }

    @Override
    public int getLast() {
        return 0;
    }

    @Override
    public int set(int index, int element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count-1) {
            Integer auxElem = tail.element;
            tail.element = element;
            return auxElem;
        }

        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        Integer auxElem = aux.element;
        aux.element = element;
        return auxElem;
    }

    @Override
    public boolean remove(int element) {
        // Se a lista esta vazia
        if (count == 0)
            return false;

        // Se remocao do primeiro elemento da lista
        if (element == head.element) {
            if (count == 1) { // se tem apenas um elemento na lista
                tail = null;
            }
            head = head.next;
            count--;
            return true;
        }

        Node ant = head; // referencia aponta para o anterior
        Node aux = head.next; // referencia aponta para o elemento que esta sendo verificado

        for (int i=1; i<count; i++) {
            if (aux.element == element) { // se achou o elemento a ser removido
                if (aux == tail) { // se remocao do ultimo
                    tail = ant;
                    tail.next = null;
                }
                else { // se remocao do meio
                    ant.next = aux.next;
                }
                count--; // atualiza cont
                return true;
            }
            aux = aux.next;
            ant = ant.next;
        }
        // Se nao removeu
        return false;
    }

    @Override
    public int removeByIndex(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        // Se remocao do primeiro
        if (index == 0) {
            Integer elemRemovido = head.element;
            head = head.next;
            if (count == 1) {// se tinha apenas um elemento na lista
                tail = null;
            }
            count--;
            return elemRemovido;
        }

        Node ant = head;
        for (int i = 0; i < index - 1; i++) {
            ant = ant.next;
        }
        Integer elemRemovido = ant.next.element;
        if (index == count - 1) { //se remocao do ultimo
            tail = ant;
            tail.next = null;
        } else { // se remocao do meio
            ant.next = ant.next.next;
            // Alternativa para o comando acima
            // Node aux = ant.next;
            // ant.next = aux.next;
        }
        count--;
        return elemRemovido;
    }

    @Override
    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Lista vazia");
        }
        int removedElement = head.element;
        head = head.next;
        count--;
        if (count == 0) {
            tail = null;
        }
        return removedElement;
    }


    @Override
    public int removeLast() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return count==0; //se count for 0, retorna true
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(int element) {
        Node aux = head;
        while(aux != null) {
            if (aux.element == element) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    public int indexOf(int element) {
        Node aux = head;
        for(int i=0; i<count; i++) {
            if (aux.element == element) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public int[] subList(int fromIndex, int toIndex)
    {
        if(fromIndex > toIndex)
            throw new IndexOutOfBoundsException();

        //Primeiro criamos um array do tamanho da sublista
        int[] sublist = new int[toIndex-fromIndex];
        Node current = head;
        //Andamos o ponteiro até o índice inicial
        for(int i =0; i < fromIndex;i++)
        {
            current=current.next;
        }
        //Adicionamos na sublista todos valores entre o início e o fim
        for(int i =0; i < toIndex-fromIndex;i++)
        {
            sublist[i] = current.element;
            current = current.next;
        }

        return sublist;
    }

    public void reverse()
    {
        Node atual = head;
        Node anterior = null;
        Node proximo;

        while(atual!=null)
        {
            proximo = atual.next; //Primeiro guardamos o ponteiro para o próximo
            atual.next = anterior; //Invertemos o link do atual para seu antecessor
            anterior = atual; //Atualizamos a referência do antecessor para a próxima iteração do while
            atual = proximo; //Atualizamos a referência do atual para próximo iteração do while
        }

        Node temp = head;
        head = tail;
        tail = temp;
    }

    public int contaOcorrencias(int element)
    {
        int total = 0;

        Node current = head;
        while(current!=null)
        {
            if (current.element == element)
                total++;
            current = current.next;
        }

        return total;
    }
}