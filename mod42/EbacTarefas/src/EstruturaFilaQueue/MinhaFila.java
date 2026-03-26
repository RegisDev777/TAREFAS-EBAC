package EstruturaFilaQueue;

public class MinhaFila {
    private int[] elementos;
    private int inicio; // Onde a fila começa (quem vai ser atendido)
    private int fim;    // Onde a fila termina (onde entram os novatos)
    private int total;  // Quantas pessoas estão na fila agora
    private int capacidade;

    // Construtor
    public MinhaFila(int tamanho) {
        this.capacidade = tamanho;
        this.elementos = new int[tamanho];
        this.inicio = 0;
        this.fim = 0;
        this.total = 0; // A fila começa zerada
    }

    // ENQUEUE: Adiciona alguém no final da fila
    public void enqueue(int valor) {
        if (total == capacidade) {
            System.out.println("Erro: A fila está cheia!");
        } else {
            elementos[fim] = valor; // A pessoa entra na vaga do 'fim'
            fim++; // O final da fila anda um passo para trás
            
            // "Truque da Fila Circular": Se o fim bater no limite do Array, 
            // ele volta pro começo (índice 0) para reaproveitar os espaços vazios.
            if (fim == capacidade) {
                fim = 0; 
            }
            
            total++; // Aumentamos a contagem de pessoas
            System.out.println("Entrou na fila: " + valor);
        }
    }

    // DEQUEUE: Remove e atende o primeiro da fila
    public int dequeue() {
        if (total == 0) {
            System.out.println("Erro: A fila está vazia!");
            return -1;
        } else {
            int valorRemovido = elementos[inicio]; // Pega quem está no 'inicio'
            inicio++; // O 'inicio' da fila anda para o próximo da fila
            
            // Se o 'inicio' bater no limite, ele também volta pro zero
            if (inicio == capacidade) {
                inicio = 0;
            }
            
            total--; // Diminuímos a contagem de pessoas
            return valorRemovido;
        }
    }
    
    
    
 // FRONT: Espia quem é o primeiro da fila (sem remover)
    public int front() {
        if (total == 0) {
            System.out.println("A fila está vazia!");
            return -1;
        }
        return elementos[inicio];
    }

    // REAR: Espia quem é o último da fila
    public int rear() {
        if (total == 0) {
            System.out.println("A fila está vazia!");
            return -1;
        }
        
        // Se o fim for 0, o último elemento está na última gaveta do array.
        // Senão, está uma posição exatamente atrás do 'fim' atual.
        int posicaoUltimo;
        if (fim == 0) {
            posicaoUltimo = capacidade - 1;
        } else {
            posicaoUltimo = fim - 1;
        }
        
        return elementos[posicaoUltimo];
    }

    // SIZE: Retorna o tamanho atual da fila
    public int size() {
        return total;
    }

    // ISEMPTY: Retorna true se estiver vazia
    public boolean isEmpty() {
        return total == 0;
    }
    
    
    
}
