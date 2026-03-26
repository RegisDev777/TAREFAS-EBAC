package EstruturaPilha;

public class TestePilha {
      public static void main(String[] args) {
    	  MinhaPilha p = new MinhaPilha(3);
          
          System.out.println("A pilha está vazia? " + p.isEmpty()); // Deve imprimir true
          
          p.push(10);
          p.push(20);
          p.push(30);
          
          System.out.println("Tamanho atual: " + p.size()); // Deve imprimir 3
          System.out.println("Espiando o topo: " + p.top()); // Deve imprimir 30
          System.out.println("A pilha está vazia? " + p.isEmpty()); // Deve imprimir false
          
          p.pop(); // Remove o 30
          System.out.println("Novo topo após o pop: " + p.top()); // Deve imprimir 20
      }
}

