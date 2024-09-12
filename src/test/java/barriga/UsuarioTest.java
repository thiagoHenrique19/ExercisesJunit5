package barriga;

import Exceptions.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static builders.UsuarioBuilderOld.umUsuario;

@DisplayName("Dominio: Usuario")
public class UsuarioTest {

    @Test
    @DisplayName("Deve Criar um usuario valido")
    public void deveCriarUsuarioValido() {
        Usuario usuario = umUsuario().agora();
        Assertions.assertAll("Usuario",
                () -> Assertions.assertEquals(1L, usuario.Id()),
                () -> Assertions.assertEquals("Usuario Valido", usuario.Nome()),
                () -> Assertions.assertEquals("user@gmail.com", usuario.Email()),
                () -> Assertions.assertEquals("123456", usuario.Senha())
        );
    }
    @Test
    public void deveRejeitarUsuarioSemNome(){
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                umUsuario().comNome(null).agora());
        Assertions.assertEquals("Nome é obrigatorio",ex.getMessage());
    }
    @Test
    public void deveRejeitarUsuarioSemEmail(){
      ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
        umUsuario().comEmail(null).agora());
        Assertions.assertEquals("Email é obrigatorio",ex.getMessage());
    }
    @Test
    public void deveRejeitarUsuarioSemSenha(){
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                umUsuario().comSenha(null).agora());
        Assertions.assertEquals("Senha é obrigatoria",ex.getMessage());
    }

@ParameterizedTest(name = "{4}")
@CsvSource(value = {
        "1, NULL, user@gmail.com, 123456, Nome é obrigatorio",
        "1, Nome usuario, NULL, 123456, Email é obrigatorio",
        "1, Nome usuario, user@gmail.com, NULL, Senha é obrigatoria",
}, nullValues = "NULL")
    public void deveValidarCamposObrigatorios(Long id, String nome,String email,String senha,String mensagem){
      ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
      umUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).agora());
      Assertions.assertEquals(mensagem,ex.getMessage());
}
}