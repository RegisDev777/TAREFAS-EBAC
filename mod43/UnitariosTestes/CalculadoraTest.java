package UnitariosTestes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }

    // Método auxiliar para conseguir acessar e executar os métodos privados via Reflection
    private int invocarMetodoPrivado(String nomeDoMetodo, int a, int b) throws Exception {
        Method metodo = Calculadora.class.getDeclaredMethod(nomeDoMetodo, int.class, int.class);
        metodo.setAccessible(true); // "Quebra" o encapsulamento private para o teste
        return (int) metodo.invoke(calculadora, a, b);
    }

    @Test
    public void testAdicionar() throws Exception {
        assertEquals(15, invocarMetodoPrivado("adicionar", 10, 5));
        assertEquals(-2, invocarMetodoPrivado("adicionar", -5, 3));
    }

    @Test
    public void testSubtrair() throws Exception {
        assertEquals(5, invocarMetodoPrivado("subtrair", 10, 5));
        assertEquals(-8, invocarMetodoPrivado("subtrair", -5, 3));
    }

    @Test
    public void testMultiplicar() throws Exception {
        assertEquals(50, invocarMetodoPrivado("multiplicar", 10, 5));
        assertEquals(0, invocarMetodoPrivado("multiplicar", 10, 0));
    }

    @Test
    public void testDividir() throws Exception {
        assertEquals(2, invocarMetodoPrivado("dividir", 10, 5));
    }

    // ATENÇÃO ESPECIAL AQUI: Testando a divisão por zero!
    @Test
    public void testDividirPorZero() {
        // Como estamos usando Reflection, a exceção real (ArithmeticException) 
        // vem empacotada dentro de uma InvocationTargetException.
        Exception excecao = assertThrows(InvocationTargetException.class, () -> {
            invocarMetodoPrivado("dividir", 10, 0);
        });
        
        // Verificamos se a causa raiz da exceção foi de fato a tentativa de dividir por zero
        assertInstanceOf(ArithmeticException.class, excecao.getCause());
        assertEquals("/ by zero", excecao.getCause().getMessage());
    }
}