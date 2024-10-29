package br.com.blog.blog.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("USUARIO NÃO ENCONTRADO");
    }
}
