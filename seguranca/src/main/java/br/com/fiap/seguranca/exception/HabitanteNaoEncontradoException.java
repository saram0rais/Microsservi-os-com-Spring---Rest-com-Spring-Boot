package br.com.fiap.seguranca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HabitanteNaoEncontradoException extends RuntimeException{

    public HabitanteNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
