
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste InteiroPositivoTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class InteiroPositivoTest
{
    @Test
    void calcula_fatorial_valor() {
        InteiroPositivo i = new InteiroPositivo();
        i.setValor(10);
        assertEquals(3628800,i.fatorial());
    }

    @Test
    void calcular_fatorial_valor2() {
        InteiroPositivo t = new InteiroPositivo(); 
        t.setValor(20);
        assertEquals(2_432_902_008_176_640_000L,t.fatorial());

    }

    @Test
    void testDivisoresInteiros() {
        // Arrange
        InteiroPositivo c;
        c = new InteiroPositivo();
        c.setValor(14);

        // Act
        String a = c.divisoresInteiros();
        // Assert
        assertEquals("1, 2, 7, 14, Quantidade de Divisores: 4", a);
    }

    @Test
    void testFibonacciDe9() {
        InteiroPositivo i = new InteiroPositivo();
        i.setValor(9);
        int[] fib = i.fibonacci();
        String r = "";
        for (int z = 0; z < fib.length; z++) {
            r += fib[z]+", ";
        }
        assertEquals("1, 1, 2, 3, 5, 8, 13, 21, 34, ", r);
    }
    
      @Test
    void testFibonacciDe14() {
        InteiroPositivo i = new InteiroPositivo();
        i.setValor(14);
        int[] fib = i.fibonacci();
        int[] esperado = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        assertArrayEquals(esperado, fib);
    }
}
