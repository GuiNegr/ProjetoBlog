package br.com.blog.blog.bean.entity;
import br.com.blog.blog.bean.dto.UsuarioRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="USUARIO_BLOG_PROJETOBLOG")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USUARIO_BLOG_ID")
      private Long id;

    @Column(name="USUARIO_BLOG_NOME", nullable=false,length=50,unique = true)
      private String nomeUsuario;

    @Column(name="USUARIO_BLOG_EMAIL", nullable=false,unique = true)
      private String email;

    @Column(name="USUARIO_BLOG_SENHA",nullable = false)
      private String senha;


    public Usuario(UsuarioRequest userRequest){
        this.nomeUsuario = userRequest.nomeUsuario();
        this.email = userRequest.email();
        this.senha = userRequest.senha();
    }


}
