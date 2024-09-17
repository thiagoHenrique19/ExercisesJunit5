package Exercicios.CodigoBarras;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BarcodeScannerTest {

        @Test
        public void testScanValidBarcode12345() {
            // código de barras '12345'
            String result = BarcodeScanner.scanBarcode("12345");
            Assertions.assertEquals("Preço: $7.25", result);
        }

        @Test
        public void testScanValidBarcode23456() {
            // código de barras '23456'
            String result = BarcodeScanner.scanBarcode("23456");
            Assertions.assertEquals("Preço: $12.50", result);
        }

        @Test
        public void testScanInvalidBarcode99999() {
            // código de barras inválido '99999'
            String result = BarcodeScanner.scanBarcode("99999");
            Assertions.assertEquals("Erro: código de barras não encontrado", result);
        }

        @Test
        public void testScanEmptyBarcode() {
            // código de barras vazio
            String result = BarcodeScanner.scanBarcode("");
            Assertions.assertEquals("Erro: código de barras vazio", result);
        }

        @Test
        public void testCalculateTotalWithValidBarcodes() {
            //  função total com múltiplos códigos de barras válidos
            String[] barcodes = {"12345", "23456"};
            String result = BarcodeScanner.calculateTotal(barcodes);

            // Verificando a resposta
            Assertions.assertTrue(result.contains("Preço: $7.25"));
            Assertions.assertTrue(result.contains("Preço: $12.50"));
            Assertions.assertTrue(result.contains("Total: $19.75"));
        }

        @Test
        public void testCalculateTotalWithInvalidBarcode() {
            //  função total com um código de barras inválido
            String[] barcodes = {"12345", "99999"};
            String result = BarcodeScanner.calculateTotal(barcodes);

            // Verificando a resposta
            Assertions.assertTrue(result.contains("Preço: $7.25"));
            Assertions.assertTrue(result.contains("Erro: código de barras não encontrado"));
            Assertions.assertTrue(result.contains("Total: $7.25"));  // Total só com os válidos
        }

        @Test
        public void testCalculateTotalWithEmptyBarcode() {
            // função total com um código de barras vazio
            String[] barcodes = {"", "23456"};
            String result = BarcodeScanner.calculateTotal(barcodes);

            // Verificando a resposta
            Assertions.assertTrue(result.contains("Erro: código de barras vazio"));
            Assertions.assertTrue(result.contains("Preço: $12.50"));
            Assertions.assertTrue(result.contains("Total: $12.50"));
        }
    }

