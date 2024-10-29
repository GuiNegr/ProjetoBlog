package br.com.blog.blog.mapper;

public interface GennericMapper {
    <T> T entidadeParaDto(Object entidade, Class<T> entidadeClass);
}
