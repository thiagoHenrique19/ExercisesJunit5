package Exercicios.CalculadoraDeCordas;

public class StringCalculator {

        public static int add(String numbers) throws Exception {
            // aqui vai lidar com o caso da string vazia
            if (numbers.isEmpty()) {
                return 0;
            }

            String delimiter = ",|\n";
            String numbersPart = numbers;

            // delimitador personalizado
            if (numbers.startsWith("//")) {
                int delimiterEndIndex = numbers.indexOf("\n");
                delimiter = numbers.substring(2, delimiterEndIndex);
                numbersPart = numbers.substring(delimiterEndIndex + 1);
            }

            String[] splitNumbers = numbersPart.split(delimiter);
            int sum = 0;
            StringBuilder negatives = new StringBuilder();

            for (String numStr : splitNumbers) {
                if (!numStr.isEmpty()) {
                    int num = Integer.parseInt(numStr);

                    if (num < 0) {
                        if (negatives.length() > 0) {
                            negatives.append(", ");
                        }
                        negatives.append(num);
                    } else if (num <= 1000) {
                        sum += num;
                    }
                }
            }

            // numeros negativos
            if (negatives.length() > 0) {
                throw new IllegalArgumentException("Números negativos não permitidos: " + negatives.toString());
            }

            return sum;
        }

        public static void main(String[] args) {
            try {
                // Test cases
                System.out.println(add(""));              // 0
                System.out.println(add("1"));             // 1
                System.out.println(add("1,2"));           // 3
                System.out.println(add("1,2\n3"));        // 6
                System.out.println(add("//;\n1;2"));      // 3
                System.out.println(add("2,6")); // 8
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

