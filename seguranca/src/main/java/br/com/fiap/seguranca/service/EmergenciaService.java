package br.com.fiap.seguranca.service;

import br.com.fiap.seguranca.dto.EmergenciaExibicaoDto;
import br.com.fiap.seguranca.exception.EmergenciaNaoEncontradaException;
import br.com.fiap.seguranca.model.Emergencia;
import br.com.fiap.seguranca.repository.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmergenciaService {

    @Autowired
    private EmergenciaRepository emergenciaRepository;

    //SALVAR
    public Emergencia salvarEmergencia(Emergencia emergencia){
        return emergenciaRepository.save(emergencia);
    }

    //BUSCAR
    public EmergenciaExibicaoDto buscarPorId(Long id){
        Optional<Emergencia> emergenciaOptional = emergenciaRepository.findById(id);
        if (emergenciaOptional.isPresent()){
            return new EmergenciaExibicaoDto(emergenciaOptional.get());
        } else {
            throw new EmergenciaNaoEncontradaException("Emergencia não existente!");
        }
    }

    public List<EmergenciaExibicaoDto> listarTodos(){
        return emergenciaRepository
                .findAll()
                .stream()
                .map(EmergenciaExibicaoDto::new)
                .toList();
    }

    ///EXCLUIR
    public void excluir(Long id){
        Optional<Emergencia> emergenciaOptional = emergenciaRepository.findById(id);
        if (emergenciaOptional.isPresent()){
            emergenciaRepository.delete(emergenciaOptional.get());
        } else {
            throw new RuntimeException("Emergencia não existente!");
        }
    }

    //ATUALIZAR
    public Emergencia atualizar(Emergencia emergencia){
        Optional<Emergencia> emergenciaOptional =
                emergenciaRepository.findById(emergencia.getId());

        if (emergenciaOptional.isPresent()){
            return emergenciaRepository.save(emergencia);
        } else {
            throw new RuntimeException("Emergencia não existente!");
        }
    }

}
