package br.com.blog.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapeamentoController {


    @GetMapping("/")
    public String home(){
        return "index.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/cadastro")
    public String cadastro(){
        return "cadastro.html";
    }

    @GetMapping("/feed")
    public String feed(){
        return "feed.html";
    }
}
