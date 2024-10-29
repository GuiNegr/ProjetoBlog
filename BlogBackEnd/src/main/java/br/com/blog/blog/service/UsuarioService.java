package br.com.blog.blog.service;

import br.com.blog.blog.bean.dto.UsuarioRequest;
import br.com.blog.blog.bean.dto.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse salvar(UsuarioRequest usuarioRequest);
    UsuarioResponse login(UsuarioRequest usuarioRequest);
}
