package br.com.blog.blog.exception;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException() {
        super("JÁ EXISTE ESTE EMAIL OU NOME DE USUARIO NO BANCO DE DADOS");
    }
}
