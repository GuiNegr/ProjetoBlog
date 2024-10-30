package br.com.blog.blog.service;

import br.com.blog.blog.bean.dto.PostagemRequest;
import br.com.blog.blog.bean.dto.PostagemResponse;

import java.util.List;

public interface PostagemService {

    public List<PostagemResponse> listar();
    public PostagemResponse inserirPostagem(PostagemRequest postagemRequest,Long idUsuario) throws Exception;
    public PostagemResponse deletarPostagem(Long idPostagem) throws Exception;
}
