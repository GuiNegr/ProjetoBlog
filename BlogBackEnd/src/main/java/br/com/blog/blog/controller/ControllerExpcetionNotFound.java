package br.com.blog.blog.controller;


import br.com.blog.blog.exception.AlreadyExistException;
import br.com.blog.blog.exception.NotFoundException;
import br.com.blog.blog.exception.PasswordDonstMatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExpcetionNotFound {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> throwNotFoundToFront(NotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<String> throwAlreadyExistToFront(AlreadyExistException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PasswordDonstMatch.class)
    public ResponseEntity<String> throwPasswordDonstMatch(PasswordDonstMatch ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
