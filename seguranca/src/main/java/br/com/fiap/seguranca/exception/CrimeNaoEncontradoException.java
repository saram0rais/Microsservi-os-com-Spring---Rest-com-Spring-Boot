package br.com.fiap.seguranca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CrimeNaoEncontradoException extends RuntimeException{

    public  CrimeNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
