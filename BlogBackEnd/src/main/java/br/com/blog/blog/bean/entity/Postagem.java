package br.com.blog.blog.bean.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
     private Long idPostagem;

    @Column(name="POSTAGEM_BLOG_POSTAGEM", nullable=false, length=500, unique = false)
     private String postagem;

    @Column(name="POSTAGEM_BLOG_USUARIO", nullable=false, length=500, unique = false)
    private String usuarioDono;

    @Column(name="POSTAGEM_BLOG_HORADEPUBLICACAO", nullable=false, length=500, unique = false)
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(unique = false)
    private Usuario fkUsuarioID;

}
