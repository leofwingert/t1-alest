public class Main {
    public static void main(String[] args) {
        // Cria uma nova pilha
        ArrayStack stack = new ArrayStack();

        // Testa se a pilha está vazia inicialmente
        System.out.println("A pilha está vazia? " + stack.isEmpty()); // true

        // Adiciona elementos à pilha
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("Tamanho da pilha após 4 push: " + stack.size()); // 4
        stack.printStack(); // Stack: 10 20 30 40

        // Testa o método top (deve retornar o elemento do topo sem removê-lo)
        System.out.println("Elemento no topo: " + stack.top()); // 40

        // Remove o elemento do topo
        System.out.println("Elemento removido: " + stack.pop()); // 40
        System.out.println("Tamanho da pilha após pop: " + stack.size()); // 3
        stack.printStack(); // Stack: 10 20 30

        // Testa novamente o topo após o pop
        System.out.println("Novo topo da pilha: " + stack.top()); // 30

        // Adiciona mais elementos para testar o redimensionamento automático
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);  // Aqui o array deve redimensionar para suportar mais elementos
        System.out.println("Tamanho da pilha após 5 push adicionais: " + stack.size()); // 8
        stack.printStack(); // Stack: 10 20 30 50 60 70 80 90

        // Limpa a pilha
        stack.clear();
        System.out.println("Tamanho da pilha após clear: " + stack.size()); // 0
        System.out.println("A pilha está vazia? " + stack.isEmpty()); // true

        // Testa o comportamento ao tentar fazer pop/top em uma pilha vazia
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Erro ao tentar remover de pilha vazia: " + e.getMessage()); // Pilha vazia.
        }

        try {
            stack.top();
        } catch (IllegalStateException e) {
            System.out.println("Erro ao tentar acessar topo de pilha vazia: " + e.getMessage()); // Pilha vazia.
        }
    }

}