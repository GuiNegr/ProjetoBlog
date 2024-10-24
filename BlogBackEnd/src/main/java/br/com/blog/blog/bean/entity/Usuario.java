package br.com.blog.blog.bean.entity;
import jakarta.persistence.*;

@Table(name="USUARIO_BLOG_PROJETOBLOG")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USUARIO_BLOG_ID")
    private Long id;

    @Column(name="USUARIO_BLOG_NOME", nullable=false,length=50)
    private String nomeUsuario;

    @Column(name="USUARIO_BLOG_EMAIL", nullable=false)
    private String email;

    @Column(name="USUARIO_BLOG_SENHA",nullable = false)
    private String senha;
}
