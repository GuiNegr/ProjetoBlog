package br.com.blog.blog.mapper;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GennericMapperImpl implements GennericMapper{


    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public <T> T entidadeParaDto(Object entidade, Class<T> entidadeClass) {
        return modelMapper.map(entidade, entidadeClass);
    }
}
