package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Exercicio1 {
	public static void main(String[] args) {
		
			
		int[] s = { 1,2,3};
        int n =  2; 
        
           List<List<Integer>> resultado = gerarSubconjuntos(s,n);
           System.out.println(resultado);
     
	}
	
	public static  List<List<Integer>> gerarSubconjuntos(int[] s, int n){
		List<List<Integer>> resultado = new  ArrayList<List<Integer>>();
		backtrack(s, n, 0, new ArrayList<Integer>(), resultado);
		return resultado;
	}
	
	public static void backtrack (int[] s, int n , int inicio, List<Integer> atual, List<List<Integer>> resultado) {
		  if(atual.size() == n) {
			  resultado.add(new ArrayList<Integer>(atual));
			  return;
		  }
		  
		  for (int i = inicio; i < s.length; i++) {
			  atual.add(s[i]);
			  backtrack(s,n,i + 1, atual,resultado);
			  atual.remove(atual.size()  -  1);
		  }
	}
	
	
}




/*  Usei backtracking para gerar todos os subconjuntos de tamanho n
 *  O algoritmo adiciona elementos gradualmente em uma lista temporária.
 *  Quando essa lista atinge tamanho n, ela é salva no resultado. 
 *  Depois disso, o algoritmo remove o último elemento e tenta outras possibilidades. */
