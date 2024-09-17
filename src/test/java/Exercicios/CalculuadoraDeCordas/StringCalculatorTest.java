package Exercicios.CalculuadoraDeCordas;

import Exercicios.CalculadoraDeCordas.StringCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
        @Test
        public void testEmptyStringReturnsZero() throws Exception {
         Assertions.assertEquals(0, StringCalculator.add(""));
        }

        @Test
        public void testSingleNumberReturnsValue() throws Exception {
           Assertions.assertEquals(1, StringCalculator.add("1"));
            Assertions.assertEquals(5, StringCalculator.add("5"));
        }

        @Test
        public void testTwoNumbersSeparatedByCommaReturnsSum() throws Exception {
            Assertions.assertEquals(3, StringCalculator.add("1,2"));
            Assertions.assertEquals(10, StringCalculator.add("4,6"));
        }

        @Test
        public void testMultipleNumbersSeparatedByCommaOrNewlineReturnsSum() throws Exception {
            Assertions.assertEquals(6, StringCalculator.add("1,2\n3"));
            Assertions.assertEquals(15, StringCalculator.add("1,2\n3,4\n5"));
        }

        @Test
        public void testCustomDelimiter() throws Exception {
            Assertions.assertEquals(3, StringCalculator.add("//;\n1;2"));
            Assertions.assertEquals(8, StringCalculator.add("2,6"));
        }

        @Test
        public void testInvalidDelimiterThrowsException() throws Exception {
            StringCalculator.add("1,2,");
        }

        @Test
        public void testNegativeNumberThrowsException() {
            try {
                StringCalculator.add("1,-2,3");
                Assertions.fail("Exception expected");
            } catch (Exception e) {
                Assertions.assertEquals("Número(s) negativo(s) não permitido(s): -2", e.getMessage());
            }

            try {
                StringCalculator.add("-1,-2,3");
                Assertions.fail("Exception expected");
            } catch (Exception e) {
                Assertions.assertEquals("Número(s) negativo(s) não permitido(s): -1, -2", e.getMessage());
            }
        }

        @Test
        public void testNumbersGreaterThan1000AreIgnored() throws Exception {
            Assertions.assertEquals(2, StringCalculator.add("2,1001"));
            Assertions.assertEquals(1002, StringCalculator.add("2,1000"));
        }

        @Test
        public void testMultipleErrors() {
            try {
                StringCalculator.add("//|\n1|2,-3");
                Assertions.fail("Exception expected");
            } catch (Exception e) {
                Assertions.assertEquals("Número(s) negativo(s) não permitido(s): -3", e.getMessage());
            }
        }
    }

