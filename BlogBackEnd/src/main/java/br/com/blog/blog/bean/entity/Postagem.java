package br.com.blog.blog.bean.entity;

import jakarta.persistence.*;

@Entity
@Table(name="POSTAGEM_BLOG_PROJETOBLOG")
public class Postagem {

    @Id
    @Column(name="POSTAGEM_BLOG_ID")
    private long id;

    @Column(name="POSTAGEM_BLOG_POSTAGEM", nullable=false, length=500)
    private String postagem;

    @ManyToOne
    @JoinColumn
    private Usuario fkUsuarioID;

}
