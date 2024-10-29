package br.com.blog.blog.controller;

import br.com.blog.blog.bean.dto.PostagemRequest;
import br.com.blog.blog.bean.dto.PostagemResponse;
import br.com.blog.blog.bean.dto.UsuarioRequest;
import br.com.blog.blog.bean.dto.UsuarioResponse;
import br.com.blog.blog.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postagem")
public class PostagemController {


    @Autowired
    private PostagemService postagemService;

    @PostMapping("/{id}")
    public ResponseEntity<HttpStatus> inserir(@RequestBody  PostagemRequest postagemRequest, @PathVariable Long id) throws Exception {
        postagemService.inserirPostagem(postagemRequest,id);
        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }


}
