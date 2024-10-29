package br.com.blog.blog.bean.dto;

import br.com.blog.blog.bean.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class PostagemRequest {
    private String postagem;
    private String usuarioDono;
    private Usuario fkUsuarioID;
}
