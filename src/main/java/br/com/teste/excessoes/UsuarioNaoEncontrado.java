package br.com.teste.excessoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

public class UsuarioNaoEncontrado extends RuntimeException {

    public UsuarioNaoEncontrado(String message){
        super( message);
    }

    public UsuarioNaoEncontrado(){
        super("Usário não encontrado no sistema");
    }
}

