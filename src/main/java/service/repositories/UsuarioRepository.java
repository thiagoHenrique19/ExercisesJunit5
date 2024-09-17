package service.repositories;

import barriga.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Usuario salvar (Usuario usuario);

   Optional<Usuario> getUserByEmail(String email);
}
