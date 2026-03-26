package EstruturaDeListaEncadeada;

public class testeLista {
	 public static void main(String[] args) {
	        MinhaListaEncadeada lista = new MinhaListaEncadeada();

	        lista.push(new Node(10));
	        lista.push(new Node(20));
	        lista.push(new Node(30));
	        
	        lista.printList(); // Deve imprimir: [10] -> [20] -> [30] -> null
	        
	        lista.insert(1, new Node(15)); // Insere o 15 na posição 1
	        System.out.println("Após inserir o 15 no índice 1:");
	        lista.printList(); // Deve imprimir: [10] -> [15] -> [20] -> [30] -> null
	        
	        Node removido = lista.pop();
	        System.out.println("Foi feito o pop do valor: " + removido.valor);
	        lista.printList(); // Deve imprimir: [10] -> [15] -> [20] -> null
	        
	        lista.remove(0); // Remove o primeiro (10)
	        System.out.println("Após remover o índice 0:");
	        lista.printList(); // Deve imprimir: [15] -> [20] -> null
	    }
}
