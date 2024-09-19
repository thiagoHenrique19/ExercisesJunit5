package Exercicios.CalculuadoraDeCordas;

import Exercicios.CalculadoraDeCordas.StringCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    public void testEmptyStringReturnsZero() throws Exception {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testSingleNumberReturnsValue() throws Exception {
        assertEquals(1, StringCalculator.add("1"));
        assertEquals(5, StringCalculator.add("5"));
    }

    @Test
    public void testTwoNumbersSeparatedByCommaReturnsSum() throws Exception {
        assertEquals(3, StringCalculator.add("1,2"));
        assertEquals(10, StringCalculator.add("4,6"));
    }

    @Test
    public void testMultipleNumbersSeparatedByCommaOrNewlineReturnsSum() throws Exception {
        assertEquals(6, StringCalculator.add("1,2\n3"));
        assertEquals(15, StringCalculator.add("1,2\n3,4\n5"));
    }

    @Test
    public void testCustomDelimiter() throws Exception {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
        assertEquals(8, StringCalculator.add("2,6"));
    }

    @Test
    public void testInvalidDelimiterThrowsException() throws Exception {
        StringCalculator.add("1,2,");
    }

    @Test
    public void testNegativeNumberThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("1,-2,3"));
        assertEquals("Números negativos não permitidos: -2", exception.getMessage());
    }

    @Test
    public void testNumbersGreaterThan1000AreIgnored() throws Exception {
        assertEquals(2, StringCalculator.add("2,1001"));
        assertEquals(1002, StringCalculator.add("2,1000"));
    }

    @Test
    public void testMultipleErrors() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("2,-3"));
        assertEquals("Números negativos não permitidos: -3", exception.getMessage());
    }
}


