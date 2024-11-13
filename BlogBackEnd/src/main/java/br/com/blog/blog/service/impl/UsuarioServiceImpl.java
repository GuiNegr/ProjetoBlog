package br.com.blog.blog.service.impl;

import br.com.blog.blog.bean.dto.UsuarioRequest;
import br.com.blog.blog.bean.dto.UsuarioResponse;
import br.com.blog.blog.bean.entity.Usuario;
import br.com.blog.blog.exception.AlreadyExistException;
import br.com.blog.blog.exception.NotFoundException;
import br.com.blog.blog.exception.PasswordDonstMatch;
import br.com.blog.blog.repository.UsuarioRepository;
import br.com.blog.blog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponse salvar(UsuarioRequest usuarioRequest) {
      Usuario usuario = new Usuario();
      if(usuarioRepository.findByNomeUsuario(usuarioRequest.nomeUsuario()).isPresent()){
          throw new AlreadyExistException();
      }
      usuario.setNomeUsuario(usuarioRequest.nomeUsuario());
      if(usuarioRepository.findByEmail(usuarioRequest.email()).isPresent()){
          throw new AlreadyExistException();
      }
      usuario.setEmail(usuarioRequest.email());
      usuario.setSenha(passwordEncoder.encode(usuarioRequest.senha()));
      usuarioRepository.save(usuario);
      return new UsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponse login(UsuarioRequest usuarioRequest) {
        Usuario usuarioCheck = usuarioRepository.findByEmail(usuarioRequest.email()).orElseThrow(() -> new NotFoundException());
        if(passwordEncoder.matches(usuarioRequest.senha(),usuarioCheck.getSenha())){
            return new UsuarioResponse(usuarioCheck);
        }else {
            throw new PasswordDonstMatch();
        }
    }
}
