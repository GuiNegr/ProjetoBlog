package br.com.blog.blog.bean.dto;

import br.com.blog.blog.bean.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class PostagemResponse {
    private long idPostagem;
    private String usuarioDono;
    private String postagem;
    private Usuario fkUsuarioID;
}
