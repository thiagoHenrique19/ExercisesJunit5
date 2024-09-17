package Exercicios.CodigoBarras;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BarcodeScanner {

        // Banco de dados de produtos com código de barras e preços
        private static final Map<String, Double> productDatabase = new HashMap<>();

        static {
            productDatabase.put("12345", 7.25);
            productDatabase.put("23456", 12.50);
        }

        // Função para processar o código de barras
        public static String scanBarcode(String barcode) {
            if (barcode == null || barcode.isEmpty()) {
                return "Erro: código de barras vazio";
            }

            Double price = productDatabase.get(barcode);

            if (price != null) {
                return "Preço: $" + String.format("%.2f", price);
            } else {
                return "Erro: código de barras não encontrado";
            }
        }

        // Função para calcular o total dos preços escaneados
        public static String calculateTotal(String[] barcodes) {
            double total = 0.0;
            StringBuilder response = new StringBuilder();

            for (String barcode : barcodes) {
                String result = scanBarcode(barcode);
                if (result.startsWith("Preço:")) {
                    double price = Double.parseDouble(result.split("\\$")[1]);
                    total += price;
                }
                response.append(result).append("\n");
            }

            response.append("Total: $").append(String.format("%.2f", total));
            return response.toString();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            System.out.println("Bem-vindo ao sistema de venda de produtos!");

            while (running) {
                System.out.println("Digite um código de barras para escanear ou 'total' para finalizar a compra:");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("total")) {
                    System.out.println("Digite os códigos de barras separados por vírgula para calcular o total:");
                    String barcodeList = scanner.nextLine();
                    String[] barcodes = barcodeList.split(",");
                    String total = calculateTotal(barcodes);
                    System.out.println(total);
                    running = false;
                } else {
                    String result = scanBarcode(input);
                    System.out.println(result);
                }
            }

            scanner.close();
            System.out.println("Obrigado por usar o sistema de venda!");
        }
    }

