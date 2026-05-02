package UnitariosTestes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeEach
    public void setUp() {
        // Inicializa a classe antes de cada teste
        fibonacci = new Fibonacci();
    }

    // Teste 1: Verifica os casos base da recursão
    @Test
    public void testCasosBase() {
        // fib(0) deve ser 0
        assertEquals(0, fibonacci.calcular(0));
        
        // fib(1) deve ser 1
        assertEquals(1, fibonacci.calcular(1));
    }

    // Teste 2: Verifica o caso demonstrado na árvore da imagem
    @Test
    public void testFibonacciDeCinco() {
        // A sequência é: 0, 1, 1, 2, 3, 5... 
        // Portanto, a 5ª posição (considerando o 0 como posição 0) é 5.
        assertEquals(5, fibonacci.calcular(5));
    }

    // Teste 3: Verifica um número um pouco maior
    @Test
    public void testFibonacciDeDez() {
        // A 10ª posição da sequência de Fibonacci resulta em 55
        assertEquals(55, fibonacci.calcular(10));
    }
    
    // Teste 4 (Bônus): Verifica se posições negativas retornam o valor esperado
    // (Dependendo de como seu professor implementou, pode ser que lance uma exceção em vez disso)
    @Test
    public void testFibonacciNegativo() {
        assertEquals(-1, fibonacci.calcular(-1));
    }
}