package br.com.fiap.seguranca.controller;

import br.com.fiap.seguranca.dto.HabitanteCadastroDto;
import br.com.fiap.seguranca.dto.HabitanteExibicaoDto;
import br.com.fiap.seguranca.model.Habitante;
import br.com.fiap.seguranca.repository.HabitanteRepository;
import br.com.fiap.seguranca.service.HabitanteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NotBlank
@RestController
@RequestMapping("/api")
public class HabitanteController {

    @Autowired
    private HabitanteService habitanteService;
    @Autowired
    private HabitanteRepository habitanteRepository;

    @PostMapping("/habitantes")
    @ResponseStatus(HttpStatus.CREATED)
    public HabitanteExibicaoDto salvar(HabitanteCadastroDto habitanteDTO){
        Habitante habitante = new Habitante();
        BeanUtils.copyProperties(habitanteDTO, habitante);

        Habitante habitanteSalvo = habitanteRepository.save(habitante);
        return new HabitanteExibicaoDto(habitanteSalvo);
    }

    @GetMapping("/habitantes")
    @ResponseStatus(HttpStatus.OK)
    public List<HabitanteExibicaoDto> litarTodos(){
        return habitanteService.listarTodos();
    }

    @GetMapping("/habitantes/{habitanteId}")
    public ResponseEntity<HabitanteExibicaoDto> buscarPorId(@PathVariable Long habitanteId){
        try{
            return ResponseEntity.ok (habitanteService.buscarPorId(habitanteId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/habitantes/{habitanteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long habitanteId){
        habitanteService.excluir(habitanteId);
    }

    @PutMapping("/habitantes")
    @ResponseStatus(HttpStatus.OK)
    public Habitante atualizar(@RequestBody Habitante habitante ){
        return habitanteService.atualizar(habitante);
    }
}
