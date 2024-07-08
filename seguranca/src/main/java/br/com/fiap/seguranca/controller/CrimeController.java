package br.com.fiap.seguranca.controller;

import br.com.fiap.seguranca.dto.CrimeExibicaoDto;
import br.com.fiap.seguranca.model.Crime;
import br.com.fiap.seguranca.service.CrimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CrimeController {

    @Autowired
    private CrimeService crimeService;

    @PostMapping("/crimes")
    @ResponseStatus(HttpStatus.CREATED)
    public Crime salvar(@RequestBody @Valid Crime crime){
        return crimeService.salvarCrime(crime);
    }

    @GetMapping("/crimes")
    @ResponseStatus(HttpStatus.OK)
    public List<CrimeExibicaoDto> litarTodos(){
        return crimeService.listarTodos();
    }

    @GetMapping("/crimes/{crimeId}")
    public ResponseEntity<CrimeExibicaoDto> buscarPorId(@PathVariable Long crimeId){
        try{
            return ResponseEntity.ok(crimeService.buscarPorId(crimeId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/crimes/{crimeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long crimeId){
        crimeService.excluir(crimeId);
    }

    @PutMapping("/crimes")
    @ResponseStatus(HttpStatus.OK)
    public Crime atualizar(@RequestBody Crime crime){
        return crimeService.atualizar(crime);
    }

}