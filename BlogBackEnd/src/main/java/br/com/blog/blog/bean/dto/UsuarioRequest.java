package br.com.blog.blog.bean.dto;


public record UsuarioRequest(
         String nomeUsuario,
         String email,
         String senha
){
public UsuarioRequest(String email,String senha){
    this("",email,senha);
}
}
