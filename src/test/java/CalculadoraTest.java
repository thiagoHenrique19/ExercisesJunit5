import org.example.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraTest {
    @Test
    public void testsSomar(){
        Calculadora calc = new Calculadora();
        Assertions.assertTrue(calc.soma(2,3) == 5);
        Assertions.assertEquals(5,calc.soma(2,3));
    }
    @Test
    public void assertivas(){
        Assertions.assertEquals("Casa","Casa");
        Assertions.assertNotEquals("Casa","casa");
        Assertions.assertTrue("casa".equalsIgnoreCase("CASA"));//n faz diferenca se tiver minusculo ou maisculo
        Assertions.assertTrue("Casa".endsWith("sa"));//endswith vai pegar as ultimas letras da palavra e fazer a comparaçao para ver se é a mesma
        Assertions.assertTrue("Casa".startsWith("Ca"));//starsWith pega as primeiras letras da palavra e faz a comparacao pra ver se é a mesma

        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        List<String> s3 = null;

        Assertions.assertEquals(s1,s2);
        Assertions.assertSame(s1,s1);
        Assertions.assertEquals(s1,s3);
        Assertions.assertNull(s3);
        Assertions.assertNotNull(s1);
      //  Assertions.fail("Falhou pelo tal motivo");//encontrou assert fail é falha,ele serve para falhar o codigo
    }
}
