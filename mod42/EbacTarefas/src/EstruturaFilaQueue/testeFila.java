package EstruturaFilaQueue;

public class testeFila {
	public static void main(String[] args) {
        // Criamos uma fila com espaço para 4 pessoas
        MinhaFila f = new MinhaFila(9);

        System.out.println("A fila está vazia? " + f.isEmpty()); // Deve ser true

        // Chegaram 3 pessoas no banco
        f.enqueue(10);
        f.enqueue(20);
        f.enqueue(30);

        System.out.println("--- Inspeção ---");
        System.out.println("Tamanho atual: " + f.size()); // Deve ser 3
        System.out.println("Quem é o primeiro (front)? " + f.front()); // Deve ser 10
        System.out.println("Quem é o último (rear)? " + f.rear());   // Deve ser 30

        System.out.println("--- Atendimento ---");
        // O caixa chama o próximo da fila
        System.out.println("Foi atendido (dequeue): " + f.dequeue()); // Remove o 10

        System.out.println("--- Nova Inspeção ---");
        // Vamos ver como a fila ficou depois do atendimento
        System.out.println("Novo primeiro da fila (front): " + f.front()); // Deve ser 20
        System.out.println("Quem é o último (rear)? " + f.rear());   // Continua sendo 30
        System.out.println("Tamanho após atendimento: " + f.size()); // Deve ser 2
    }
}
