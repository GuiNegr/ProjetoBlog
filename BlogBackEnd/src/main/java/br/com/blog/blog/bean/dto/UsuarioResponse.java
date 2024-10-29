package br.com.blog.blog.bean.dto;
import br.com.blog.blog.bean.entity.Usuario;

public record UsuarioResponse (
     Long id,
     String nomeUsuario,
     String email,
     String senha
){
    public UsuarioResponse(Long id, String nomeUsuario, String email, String senha) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioResponse(Usuario usuario) {
        this(usuario.getId(), usuario.getNomeUsuario(), usuario.getEmail(), usuario.getSenha());
    }
}
