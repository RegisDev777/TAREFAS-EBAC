package BackTracking;

public class Exercicio2 {
  public static void main(String[] args) {
	
	  
	  int quantia = 18;
	  int[] moedas  = {5,2,1};
	  
	  int totalMoedas = calcularTrocoMinimo(quantia,  moedas );
	  System.out.println("menor numeros de moedas: "  +  totalMoedas);	 
  }
  
  
  public static int  calcularTrocoMinimo(int quantia,  int[]moedas) {
	  int quantidadesMoedas = 0;
	   for(int  moeda : moedas) {
		   while (quantia >= moeda) {
			   quantia  -=  moeda;
			   quantidadesMoedas++;
		   }
	   }
	   return quantidadesMoedas;
  }
  
  
}

 /* Usei um algoritmo guloso, escolhendo sempre a maior moeda possível que ainda cabe na quantia restante.
  *  O processo se repete até a quantia chegar a zero. Assim, 
  *  no exemplo de 18 com moedas 5, 2 e 1, o total mínimo obtido é 5 moedas.
  */


