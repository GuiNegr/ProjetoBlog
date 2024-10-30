package br.com.blog.blog.repository;

import br.com.blog.blog.bean.dto.PostagemResponse;
import br.com.blog.blog.bean.entity.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    Postagem deletePostagemByIdPostagem(Long id);
}
