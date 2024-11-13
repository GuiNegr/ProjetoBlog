package br.com.blog.blog.exception;

public class PasswordDonstMatch extends RuntimeException{
    public PasswordDonstMatch() {
        super("SENHA ESTÁ ERRADA");
    }
}
