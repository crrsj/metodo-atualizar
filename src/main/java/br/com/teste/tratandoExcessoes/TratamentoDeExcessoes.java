package br.com.teste.tratandoExcessoes;

import br.com.teste.excessoes.UsuarioNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TratamentoDeExcessoes extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontrado.class)
    private ResponseEntity<String>usuarioNaoEncontrado(UsuarioNaoEncontrado excessao){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario não encontado");
    }
}
