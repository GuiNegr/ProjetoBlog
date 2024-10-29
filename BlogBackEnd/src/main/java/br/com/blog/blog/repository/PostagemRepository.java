package br.com.blog.blog.repository;

import br.com.blog.blog.bean.entity.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}
