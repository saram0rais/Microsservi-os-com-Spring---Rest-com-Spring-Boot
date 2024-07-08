package br.com.fiap.seguranca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmergenciaNaoEncontradaException extends RuntimeException{

    public EmergenciaNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
