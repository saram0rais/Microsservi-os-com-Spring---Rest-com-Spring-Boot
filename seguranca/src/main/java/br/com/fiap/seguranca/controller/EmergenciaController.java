package br.com.fiap.seguranca.controller;

import br.com.fiap.seguranca.dto.EmergenciaExibicaoDto;
import br.com.fiap.seguranca.model.Emergencia;
import br.com.fiap.seguranca.service.EmergenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmergenciaController {

    @Autowired
    private EmergenciaService emergenciaService;

    @PostMapping("/emergencias")
    @ResponseStatus(HttpStatus.CREATED)
    public Emergencia salvar(@RequestBody @Valid Emergencia emergencia){
        return emergenciaService.salvarEmergencia(emergencia);
    }

    @GetMapping("/emergencias")
    @ResponseStatus(HttpStatus.OK)
    public List<EmergenciaExibicaoDto> listarTodos(){
        return emergenciaService.listarTodos();
    }

    @GetMapping("/emergencias/{emergenciaId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmergenciaExibicaoDto> buscarPorId(@PathVariable Long emergenciaId){
        try {
            return ResponseEntity.ok(emergenciaService.buscarPorId(emergenciaId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/emergencias/{emergenciaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long emergenciaId){
        emergenciaService.excluir(emergenciaId);
    }

    @PutMapping("/emergencias")
    @ResponseStatus(HttpStatus.OK)
    public Emergencia atualizar(@RequestBody Emergencia emergencia){
        return emergenciaService.atualizar(emergencia);
    }

}