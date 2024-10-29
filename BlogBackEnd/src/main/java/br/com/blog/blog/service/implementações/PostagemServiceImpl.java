package br.com.blog.blog.service.implementações;

import br.com.blog.blog.bean.dto.PostagemRequest;
import br.com.blog.blog.bean.dto.PostagemResponse;
import br.com.blog.blog.bean.entity.Postagem;
import br.com.blog.blog.bean.entity.Usuario;
import br.com.blog.blog.mapper.GennericMapper;
import br.com.blog.blog.repository.PostagemRepository;
import br.com.blog.blog.repository.UsuarioRepository;
import br.com.blog.blog.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class PostagemServiceImpl implements PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GennericMapper gennericMapper;

    @Override
    public PostagemResponse inserirPostagem(PostagemRequest postagemRequest,Long id) throws Exception {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new Exception("NÃO FOI POSSIVEL LOCALIZAR NENHUM USUARIO"));
        Postagem postagem = new Postagem();
        postagem.setPostagem(postagemRequest.getPostagem());
        postagem.setFkUsuarioID(usuario);
        postagem.setUsuarioDono(usuario.getNomeUsuario());
        postagemRepository.save(postagem);
        return gennericMapper.entidadeParaDto(postagem,PostagemResponse.class);
    }
}
