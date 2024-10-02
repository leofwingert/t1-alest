public class DoublyLinkedList implements ListTAD {

    private Node header;
    private Node trailer;
    private int count;

    private class Node {
        public Integer element;
        public Node previous;
        public Node next;

        public Node()
        {
            this.element = null;
            this.previous = null;
            this.next = null;
        }

        public Node(Integer element, Node previous, Node next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
    }
    public DoublyLinkedList()
    {
        header = new Node();
        trailer = new Node();
        header.next = trailer;
        trailer.previous = header;
        count = 0;
    }
    
    private void addBetween(int element, Node prev, Node next)
    {
        Node newNode = new Node(element, prev, next);
        prev.next = newNode;
        next.previous = newNode;
        count++;
    }

    @Override
    public void add(int element) {
        addBetween(element, trailer.previous, trailer);        
    }

    @Override
    public void add(int index, int element) {
        if ((index < 0) || (index > count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }

        Node aux = header.next;
        for(int i = 0; i < index; i++)
        {
            aux = aux.next;
        }
        addBetween(element, aux.previous, aux);
    }

    @Override
    public void addFirst(int e) {
        addBetween(e, header, header.next);
    }

    @Override
    public int get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node aux = header.next;
        for(int i = 0; i < index; i++)
        {
            aux = aux.next;
        }
        return aux.element;
    }

    @Override
    public int getFirst() {
        return this.get(0);
    }

    @Override
    public int getLast() {
        return this.get(count-1);
    }

    @Override
    public int set(int index, int element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node aux = header.next;
        for(int i = 0; i < index; i++)
        {
            aux = aux.next;
        }
        int oldValue = aux.element;
        aux.element = element;
        return oldValue;
    }

    @Override
    public boolean remove(int element) {
        int index = indexOf(element);
        if(index != -1)
        {
            removeByIndex(index);
            return true;
        }
        else
            return false;
    }

    @Override
    public int removeByIndex(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }

        Node aux = header.next;

        for(int i = 0; i < index; i++)
        {
            aux = aux.next;
        }
        aux.previous.next = aux.next;
        aux.next.previous = aux.previous;
        count--;
        return aux.element;
    }

    @Override
    public int removeFirst() {
       
        if (count > 0) {
            Node first = header.next;
            header.next = first.next;
            first.next.previous = header;
            count--;
            return first.element;
        }
        
        return -1;
    }

    @Override
    public int removeLast() {

        if (count > 0) {
            Node last = trailer.previous;
            last.previous.next = trailer;
            trailer.previous = last.previous;
            count--;
            return last.element;
        }
        
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(int element) {
        Node aux = header.next;
        for(int i = 0; i < count; i++)
        {
            if(aux.element == element)
            {
                return i;
            } 
            aux = aux.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        this.count = 0;
        this.header.next = trailer;
        this.trailer.previous = header;
    }

    @Override
    public String toString() {
        if(this.count > 0)
        {
            StringBuilder aux = new StringBuilder("[ ");
            Node ptr = header.next;
            while (ptr != trailer) {
                aux = aux.append(ptr.element).append(" ");
                ptr = ptr.next; // avança para o próximo nodo
            }
            aux.append("]");
            return aux.toString();
        }

        return "Lista vazia";
    }

    public String toStringReversa() {
        if(this.count > 0)
        {
            StringBuilder aux = new StringBuilder("[ ");
            Node ptr = trailer.previous;
            while (ptr != header) {
                aux = aux.append(ptr.element).append(" ");
                ptr = ptr.previous; // avança para o próximo nodo
            }
            aux.append("]");
            return aux.toString();
        }

        return "Lista vazia";
    }

    public void reverse()
    {
        if(count>1)
        {
            Node current = header.next.next;
            Node primeiro = header.next;
            Node ultimo = trailer.previous;

            while(current!=trailer)
            {
                Node proximo = current.next;
                current.next = current.previous;
                current.previous = proximo;
                current = proximo;
            }
            trailer.previous = primeiro;
            header.next = ultimo;
            ultimo.previous = header;
            primeiro.previous = primeiro.next;
            primeiro.next = trailer;
        }
    }

    /*
     * Ordena lista com custo O(n²)'
     */
    public void bubbleSort()
    {
        if(count>1)
        {
            boolean swap = true;

            while(swap)
            {
                swap = false;
                Node current = header.next;
                
                while(current.next != trailer)
                {
                    Node proximo = current.next;
                    if(current.element > proximo.element)
                    {
                        Node anterior = current.previous;
                        Node posterior = proximo.next;

                        anterior.next = proximo;
                        proximo.previous = anterior;

                        proximo.next = current;
                        current.previous = proximo;

                        current.next = posterior;
                        posterior.previous = current;

                        swap=true;
                    }
                    else
                    {
                        current = current.next; 
                    }
                }
            }
        }
    }

    public void insertionSort() {
        if (count > 1) 
        {
            Node current = header.next.next; // Começa do segundo elemento
        
            while (current != trailer) 
            {
                Node nodoParaInserir = current; 
                Node anterior = current.previous;
        
                // Encontra a posição correta para inserir o nodo
                while (anterior != header && anterior.element > nodoParaInserir.element) 
                {
                    anterior = anterior.previous;
                }
        
                // Remove o nodo da sua posição atual
                current.previous.next = current.next;
                current.next.previous = current.previous;
                
        
                // Insere o nodo na posição correta
                Node proximo = anterior.next; 
                nodoParaInserir.next = proximo;
                nodoParaInserir.previous = anterior;
                anterior.next = nodoParaInserir;
                proximo.previous = nodoParaInserir;
        
                current = current.next; 
            }
        }
    }

}
