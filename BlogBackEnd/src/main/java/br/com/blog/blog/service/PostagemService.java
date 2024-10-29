package br.com.blog.blog.service;

import br.com.blog.blog.bean.dto.PostagemRequest;
import br.com.blog.blog.bean.dto.PostagemResponse;

public interface PostagemService {

    public PostagemResponse inserirPostagem(PostagemRequest postagemRequest,Long idUsuario) throws Exception;
}
