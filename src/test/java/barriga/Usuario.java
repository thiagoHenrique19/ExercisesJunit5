package barriga;

import Exceptions.ValidationException;

import java.util.Objects;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(Long id, String nome, String email,String senha){
        if (nome == null) throw new ValidationException("Nome é obrigatorio");
        if (email == null) throw new ValidationException("Email é obrigatorio");
        if (senha == null) throw new ValidationException("Senha é obrigatoria");


        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long Id() {
        return id;
    }

    public String Nome() {
        return nome;
    }

    public String Email() {
        return email;
    }

    public String Senha() {
        return senha;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, nome, senha);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
                && Objects.equals(senha, other.senha);
    }
}
