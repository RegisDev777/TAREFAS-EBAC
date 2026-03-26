package EstruturaDeListaEncadeada;

public class MinhaListaEncadeada {
    Node primeiroNo; // A locomotiva (o início da lista)
    int tamanho;

    public MinhaListaEncadeada() {
        this.primeiroNo = null;
        this.tamanho = 0;
    }

    // 1. PUSH: Adiciona ao fim da lista
    public void push(Node node) {
        if (primeiroNo == null) {
            // Se a lista está vazia, o novo nó é o primeiro
            primeiroNo = node;
        } else {
            // Se não está vazia, temos que viajar até ao último vagão
            Node atual = primeiroNo;
            while (atual.proximo != null) {
                atual = atual.proximo; // Pula para o vagão seguinte
            }
            // Chegamos ao fim. Engatamos o novo vagão aqui.
            atual.proximo = node;
        }
        tamanho++;
    }

    // 2. POP: Remove do fim da lista e retorna
    public Node pop() {
        if (primeiroNo == null) return null; // Lista vazia

        // Se só tem 1 elemento
        if (primeiroNo.proximo == null) {
            Node removido = primeiroNo;
            primeiroNo = null;
            tamanho--;
            return removido;
        }

        // Se tem mais de 1, viajamos até ao PENÚLTIMO vagão
        Node atual = primeiroNo;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }
        
        Node removido = atual.proximo; // Salva o último
        atual.proximo = null; // Corta o engate (agora o penúltimo passa a ser o último)
        tamanho--;
        return removido;
    }

    // 3. INSERT: Adiciona numa posição específica
    public void insert(int index, Node node) {
        if (index < 0 || index > tamanho) {
            System.out.println("Índice inválido!");
            return;
        }

        if (index == 0) {
            // Inserir no início: o engate do novo nó aponta para o antigo primeiro
            node.proximo = primeiroNo;
            primeiroNo = node; // O novo nó vira o primeiro
        } else {
            // Viajamos até ao vagão ANTERIOR à posição desejada
            Node atual = primeiroNo;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            // Fazemos a troca de engates
            node.proximo = atual.proximo;
            atual.proximo = node;
        }
        tamanho++;
    }

    // 4. REMOVE: Remove de uma posição específica
    public void remove(int index) {
        if (index < 0 || index >= tamanho || primeiroNo == null) {
            System.out.println("Índice inválido ou lista vazia!");
            return;
        }

        if (index == 0) {
            // Remover o primeiro: a locomotiva passa a ser o segundo vagão
            primeiroNo = primeiroNo.proximo;
        } else {
            // Viajamos até ao vagão ANTERIOR ao que queremos remover
            Node atual = primeiroNo;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            // O vagão atual pula o vagão da frente e engata no seguinte
            atual.proximo = atual.proximo.proximo;
        }
        tamanho--;
    }

    // 5. ELEMENTAT: Retorna o nó numa posição específica
    public Node elementAt(int index) {
        if (index < 0 || index >= tamanho || primeiroNo == null) {
            return null;
        }
        
        Node atual = primeiroNo;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual;
    }

    // 6. SIZE: Retorna o tamanho
    public int size() {
        return tamanho;
    }

    // 7. PRINTLIST: Mostra a lista como texto
    public void printList() {
        if (primeiroNo == null) {
            System.out.println("A lista está vazia.");
            return;
        }
        
        Node atual = primeiroNo;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print("[" + atual.valor + "] -> ");
            atual = atual.proximo;
        }
        System.out.println("null"); // Mostra que chegou ao fim
    }


   
}