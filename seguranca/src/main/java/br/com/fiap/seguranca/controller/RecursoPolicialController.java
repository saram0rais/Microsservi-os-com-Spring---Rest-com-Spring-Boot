package br.com.fiap.seguranca.controller;

import br.com.fiap.seguranca.dto.RecursoPolicialExibicaoDto;
import br.com.fiap.seguranca.model.RecursoPolicial;
import br.com.fiap.seguranca.service.RecursoPolicialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecursoPolicialController {

    @Autowired
    private RecursoPolicialService recursoPolicialService;

    @PostMapping("/recursos")
    @ResponseStatus(HttpStatus.CREATED)
    public RecursoPolicial salvar(@RequestBody @Valid RecursoPolicial recursoPolicial){
        return recursoPolicialService.salvarRecurso(recursoPolicial);
    }

    @GetMapping("/recursos")
    @ResponseStatus(HttpStatus.OK)
    public List<RecursoPolicialExibicaoDto> litarTodos(){
        return recursoPolicialService.listarTodos();
    }

    @GetMapping("/recursos/{recursoId}")
    public ResponseEntity<RecursoPolicialExibicaoDto> buscarPorId(@PathVariable Long recursoId){
        try{
            return ResponseEntity.ok(recursoPolicialService.buscarPorId(recursoId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/recursos/{recursoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long recursoId){
        recursoPolicialService.excluir(recursoId);
    }

    @PutMapping("/recursos")
    @ResponseStatus(HttpStatus.OK)
    public RecursoPolicial atualizar(@RequestBody RecursoPolicial recursoPolicial ){
        return recursoPolicialService.atualizar(recursoPolicial);
    }
}
