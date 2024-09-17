package builders;

import barriga.Usuario;

public class UsuarioBuilderOld {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    public static UsuarioBuilderOld umUsuario(){
        UsuarioBuilderOld builder = new UsuarioBuilderOld();
        inicializarDadosPadroes(builder);
        return builder;
    }
    private static void inicializarDadosPadroes(UsuarioBuilderOld builder){
        builder.id = 1L;
        builder.nome = "Usuario Valido";
        builder.email = "user@gmail.com";
        builder.senha = "123456";
    }
    public UsuarioBuilderOld comId(Long param){
        id = param;
        return this;
    }
    public UsuarioBuilderOld comNome(String param){
        nome = param;
        return this;
    }
    public UsuarioBuilderOld comEmail(String param){
        email = param;
        return this;
    }
    public UsuarioBuilderOld comSenha(String param){
         senha = param;
        return this;
    }
    public Usuario agora(){
         return new Usuario(id,nome,email,senha);
    }
}
