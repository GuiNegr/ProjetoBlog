package br.com.blog.blog.bean.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="POSTAGEM_BLOG_PROJETOBLOG")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Postagem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POSTAGEM_BLOG_ID")
     private long idPostagem;

    @Column(name="POSTAGEM_BLOG_POSTAGEM", nullable=false, length=500, unique = false)
     private String postagem;

    @Column(name="POSTAGEM_BLOG_USUARIO", nullable=false, length=500, unique = false)
    private String usuarioDono;

    @ManyToOne
    @JoinColumn(unique = false)
    private Usuario fkUsuarioID;

}
