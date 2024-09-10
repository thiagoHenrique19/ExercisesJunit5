import org.example.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CalculadoraTest {
    private Calculadora calc = new Calculadora();
    private int contador = 0;

    //@BeforeEach serve para ser executado antes de cada um dos nossos testes
    //@BeforeAll vai ser executado apenas uma vez para cada execucao e
    // vai ser executado no momento em que a classe for criada


    @Test
    public void testsSomar(){
        System.out.println(++contador);
        assertTrue(calc.soma(2,3) == 5);//Afirma que a condição fornecida é verdadeira
        assertEquals(5,calc.soma(2,3));

    }
    @Test
    public void assertivas(){
        System.out.println(++contador);
        assertEquals("Casa","Casa");//informa que os valores sao iguais
        assertNotEquals("Casa","casa");//informa que os valores nao sao iguais
        assertTrue("casa".equalsIgnoreCase("CASA"));//n faz diferenca se tiver minusculo ou maisculo
        assertTrue("Casa".endsWith("sa"));//endswith vai pegar as ultimas letras da palavra e fazer a comparaçao para ver se é a mesma
        assertTrue("Casa".startsWith("Ca"));//starsWith pega as primeiras letras da palavra e faz a comparacao pra ver se é a mesma

        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        List<String> s3 = null;

        assertEquals(s1,s2);
        assertSame(s1,s1);
        assertEquals(s1,s3);
        assertNull(s3);
        assertNotNull(s1);
      //  Assertions.fail("Falhou pelo tal motivo");//encontrou assert fail é falha,ele serve para falhar o codigo
    }
    @Test
    public void deveRetornarNumeroInteiroNaDivisao(){
        System.out.println(++contador);
       float resultado = calc.dividir(10,2);
       assertEquals(5,resultado);
    }
    @Test
    public void deveRetornarNumeroNegativoNaDivisao(){
        System.out.println(++contador);
        float resultado = calc.dividir(6,-2);
        assertEquals(-3,resultado);
    }
    @Test
    public void deveRetornarNumeroDecimalNaDivisao(){
        float resultado = calc.dividir(10,3);
        assertEquals(3.3333332538604736,resultado);
        assertEquals(3.33,resultado, 0.01);
    }
@Test
public void deveRetornarZeroComNumeradorZeroNaDivisao(){
        float resultado = calc.dividir(0,2);
        assertEquals(0,resultado);
}
    @Test
    public void deveLancarExcecaoQuandoDividirPorZero_Junit4(){
        try {
                float resultado = 10 / 0;
                fail("deveria ter sido lancado numa excecao na divisao  ");
        }catch (ArithmeticException e){
              assertEquals("/by zero", e.getMessage());
        }
    }
@Test
    public void deveLancarExcecaoQuandoDividirPorZero_Junit5(){
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            float resultado = 10 / 0;
        });
    assertEquals("/ by zero", exception.getMessage());
    }


}
