package br.com.blog.blog.controller;

import br.com.blog.blog.bean.dto.PostagemRequest;
import br.com.blog.blog.bean.dto.PostagemResponse;
import br.com.blog.blog.bean.dto.UsuarioRequest;
import br.com.blog.blog.bean.dto.UsuarioResponse;
import br.com.blog.blog.service.PostagemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<HttpStatus> deletar(@PathVariable Long id) throws Exception {
        PostagemResponse postagemResponse = postagemService.deletarPostagem(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }


    @GetMapping("/CarregarFeed")
    public ResponseEntity<List<PostagemResponse>> listar(){
        List<PostagemResponse> postagemResponses = postagemService.listar();
        return ResponseEntity.ok().body(postagemResponses);
    }


}
