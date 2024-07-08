package br.com.fiap.seguranca.controller;

import br.com.fiap.seguranca.dto.SistemaVigilanciaExibicaoDto;
import br.com.fiap.seguranca.model.SistemaVigilancia;
import br.com.fiap.seguranca.service.SistemaVigilanciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sistemas")
public class SistemaVigilanciaController {

    @Autowired
    private SistemaVigilanciaService sistemaVigilanciaService;

    @PostMapping("/sistemas")
    @ResponseStatus(HttpStatus.CREATED)
    public SistemaVigilancia salvar(@RequestBody @Valid SistemaVigilancia sistemaVigilancia){
        return sistemaVigilanciaService.salvarSistema(sistemaVigilancia);
    }

    @GetMapping("/api")
    @ResponseStatus(HttpStatus.OK)
    public List<SistemaVigilanciaExibicaoDto> litarTodos(){
        return sistemaVigilanciaService.listarTodos();
    }

    @GetMapping("/sistemas/{sistemaId}")
    public ResponseEntity<SistemaVigilanciaExibicaoDto> buscarPorId(@PathVariable Long sistemaId){
        try {
            return ResponseEntity.ok(sistemaVigilanciaService.buscarPorId(sistemaId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/sistemas/{sistemaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long sistemaId){
        sistemaVigilanciaService.excluir(sistemaId);
    }

    @PutMapping("/sistemas")
    @ResponseStatus(HttpStatus.OK)
    public SistemaVigilancia atualizar(@RequestBody SistemaVigilancia sistemaVigilancia){
        return sistemaVigilanciaService.atualizar(sistemaVigilancia);
    }

}
