package Exercicios.ValidationPasswordTest;

import Exercicios.ValidationPassword.PasswordValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {
        @Test
        public void testPasswordWithLessThan8Characters() {
            PasswordValidation.ValidationResult result = PasswordValidation.validatePassword("Pass1!");
            Assertions.assertFalse(result.isValid());
            Assertions.assertEquals("A senha deve ter pelo menos 8 caracteres", result.getErrorMessages());
        }

        @Test
        public void testPasswordWithoutEnoughNumbers() {
            PasswordValidation.ValidationResult  result = PasswordValidation.validatePassword("Password!");
            Assertions.assertFalse(result.isValid());
            Assertions.assertEquals("A senha deve conter pelo menos 2 números", result.getErrorMessages());
        }

        @Test
        public void testPasswordWithoutUpperCaseLetter() {
            PasswordValidation.ValidationResult  result = PasswordValidation.validatePassword("password12!");
            Assertions.assertFalse(result.isValid());
            Assertions.assertEquals("A senha deve conter pelo menos uma letra maiúscula", result.getErrorMessages());
        }

        @Test
        public void testPasswordWithoutSpecialCharacter() {
            PasswordValidation.ValidationResult  result = PasswordValidation.validatePassword("Password12");
            Assertions.assertFalse(result.isValid());
            Assertions.assertEquals("A senha deve conter pelo menos um caractere especial", result.getErrorMessages());
        }

        @Test
        public void testPasswordWithMultipleErrors() {
            PasswordValidation.ValidationResult  result = PasswordValidation.validatePassword("pass12");
            Assertions.assertFalse(result.isValid());
            Assertions.assertEquals("A senha deve ter pelo menos 8 caracteres\n" +
                            "A senha deve conter pelo menos uma letra maiúscula\n" +
                            "A senha deve conter pelo menos um caractere especial",
                    result.getErrorMessages());
        }

        @Test
        public void testValidPassword() {
            PasswordValidation.ValidationResult  result = PasswordValidation.validatePassword("Password12!");
            Assertions.assertTrue(result.isValid());
            Assertions.assertEquals("", result.getErrorMessages());
        }
    }


