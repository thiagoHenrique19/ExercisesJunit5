package barriga;

import Exceptions.ValidationException;
import builders.ContaBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static builders.UsuarioBuilder.umUsuario;

public class ContaTest {
    @Test
    public void deveCriarContaValida(){
        //criar uma conta e fazer
        Conta conta = ContaBuilder.umaConta().agora();
        // assertivas em cima da conta
        Assertions.assertAll("Conta",
                () -> Assertions.assertEquals(1l,conta.id()),
                () -> Assertions.assertEquals("Conta Valida",conta.nome()),
                () -> Assertions.assertEquals(umUsuario().agora(),conta.usuario())
                );
    }
   @ParameterizedTest
   @MethodSource(value = "dataProvider")
   public void deveRejeitarContaInvalida(Long id, String nome, Usuario usuario, String mensagem){
       String errorMessage = Assertions.assertThrows(ValidationException.class, () ->
       umaConta().comId(id).comNome(nome).comUsuario(usuario).agora()).getMessage();
        Assertions.assertEquals(mensagem, errorMessage);
   }
   private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(1L, null, umUsuario().agora(), "Nome é obrigatorio"),
                Arguments.of(1L, "Conta Valida",null, "Usuario é obrigatorio"),
                Arguments.of(1L, "Conta Valida",null, "Nome é obrigatorio")
        );

   }
}
