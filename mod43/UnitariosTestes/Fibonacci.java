package UnitariosTestes;

public class Fibonacci {

    // Método recursivo para calcular o n-ésimo número de Fibonacci
    public int calcular(int n) {
        // Casos base
        if (n <= 1) {
            return n;
        }
        // Chamada recursiva (exatamente como a árvore da imagem mostra)
        return calcular(n - 1) + calcular(n - 2);
    }
}
