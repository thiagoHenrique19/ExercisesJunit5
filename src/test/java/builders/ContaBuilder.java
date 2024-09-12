package builders;

import barriga.Conta;
import barriga.Usuario;

public class ContaBuilder {
private Long id;
private String nome;
private Usuario usuario;

private ContaBuilder () {}

    public static ContaBuilder umaConta() {
    ContaBuilder builder = new ContaBuilder();
    inicializarDadosPadroes(builder);
    return builder;
    }
    public static void inicializarDadosPadroes(ContaBuilder builder){
        builder.id = 1L;
        builder.nome = "Conta Valida";
        builder.usuario = UsuarioBuilder.umUsuario().agora();
    }
    public ContaBuilder ComID(Long id){
        this.id = id;
        return this;
    }
    public ContaBuilder ComNome(String nome){
        this.nome = nome;
        return this;
    }
    public ContaBuilder ComUsuario(Usuario usuario){
        this.usuario = usuario;
        return this;
    }
    public Conta agora() {
        return new Conta(id,nome, usuario);
    }

}
