package br.com.blog.blog.controller;


import br.com.blog.blog.bean.dto.UsuarioRequest;
import br.com.blog.blog.bean.dto.UsuarioResponse;
import br.com.blog.blog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/usuario")
@RestController
public class UsuarioController{

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<HttpStatus> salvar(@RequestBody UsuarioRequest usuarioRequest){
        usuarioService.salvar(usuarioRequest);
        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponse> login(@RequestBody UsuarioRequest usuarioRequest){
        UsuarioResponse usuarioResponse = usuarioService.login(usuarioRequest);
        return ResponseEntity.ok().body(usuarioResponse);
    }
}
