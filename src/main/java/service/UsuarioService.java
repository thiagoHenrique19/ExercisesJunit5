package service;

import Exceptions.ValidationException;
import barriga.Usuario;
import service.repositories.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public Usuario salvar(Usuario usuario){
        repository.getUserByEmail(usuario.Email()).ifPresent(user -> {
            throw new ValidationException(String.format("Usuario %s ja cadastrado!" , usuario.Email()));
                });
        return repository.salvar(usuario);
    }
}
