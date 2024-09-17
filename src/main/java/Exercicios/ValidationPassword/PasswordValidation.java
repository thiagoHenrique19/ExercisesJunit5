package Exercicios.ValidationPassword;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidation {
    public static class ValidationResult {
        private boolean isValid;
        private String errorMessages;

        public ValidationResult(boolean isValid, String errorMessages) {
            this.isValid = isValid;
            this.errorMessages = errorMessages;
        }
        public boolean isValid() {
            return isValid;
        }
        public String getErrorMessages() {
            return errorMessages;
        }
    }
    public static ValidationResult validatePassword(String password) {
        List<String> errors = new ArrayList<>();

        //pelo menos 8 caracteres
        if (password.length() < 8) {
            errors.add("A senha deve ter pelo menos 8 caracteres");
        }

        // pelo menos 2 números
        long digitCount = password.chars().filter(Character::isDigit).count();
        if (digitCount < 2) {
            errors.add("A senha deve conter pelo menos 2 números");
        }

        // pelo menos uma letra maiúscula
        boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
        if (!hasUpperCase) {
            errors.add("A senha deve conter pelo menos uma letra maiúscula");
        }

        //  no minimo um caractere especial
        boolean hasSpecialChar = password.chars().anyMatch(ch ->
                "!@#$%^&*()_+-=~`[]{}|;:,.<>?/".indexOf(ch) >= 0);
        if (!hasSpecialChar) {
            errors.add("A senha deve conter pelo menos um caractere especial");
        }

        boolean isValid = errors.isEmpty();
        String errorMessage = String.join("\n", errors);
        return new ValidationResult(isValid, errorMessage);
    }

    public static void main(String[] args) {

        ValidationResult result = validatePassword("somepassword");
        System.out.println("É válida? " + result.isValid());
        System.out.println("Erros: \n" + result.getErrorMessages());


        ValidationResult validResult = validatePassword("Password12!");
        System.out.println("É válida? " + validResult.isValid());
        System.out.println("Erros: \n" + validResult.getErrorMessages());
    }
}

