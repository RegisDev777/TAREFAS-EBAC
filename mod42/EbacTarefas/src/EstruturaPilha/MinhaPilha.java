package EstruturaPilha;

public class MinhaPilha {
	
	
	private int[] elementos;
    private int topo;
    private int capacidade;
    
				    public MinhaPilha(int tamanhoArray) { 
				        this.capacidade = tamanhoArray; 
				        this.elementos = new int[tamanhoArray];
				        this.topo = -1;
				    }
				    
				    
				
				    public void push(int valor) {
				        if(topo == capacidade - 1) {
				            System.out.println("Erro: A pilha está cheia!");
				        } else {
				            topo++;
				            elementos[topo] = valor;
				            System.out.println("Inserido: " + valor);
				        }
				    }
				            
				  
				    
				    public int pop() {
				        if(topo == -1) {
				            System.out.println("Erro: A Pilha está vazia!");
				            return -1;
				        } else {
				            int valorRemovido = elementos[topo];
				            topo--;
				            return valorRemovido;
				        }
				    }
				
				
				    
				    public int top() {
				        if(topo == -1) {
				            System.out.println("A pilha está vazia, "
				            		+ "não há o que espiar!");
				            return -1; 
				        } else {
				            return elementos[topo];
				        }
				    }
				    
				    
				    
				    
				    public boolean isEmpty() {
				        return (topo == -1); 
				    }
				
				    
				    
				
				    public int size() {    
				        return topo + 1; 
				    }
}
