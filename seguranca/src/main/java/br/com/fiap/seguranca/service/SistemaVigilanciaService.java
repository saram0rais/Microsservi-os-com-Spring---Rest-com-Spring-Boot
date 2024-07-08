package br.com.fiap.seguranca.service;


import br.com.fiap.seguranca.dto.SistemaVigilanciaExibicaoDto;
import br.com.fiap.seguranca.exception.SistemaNaoEncontradoException;
import br.com.fiap.seguranca.model.SistemaVigilancia;
import br.com.fiap.seguranca.repository.SistemaVigilanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SistemaVigilanciaService {

    @Autowired
    private SistemaVigilanciaRepository sistemaVigilanciaRepository;

    //SALVAR
    public SistemaVigilancia salvarSistema(SistemaVigilancia habitante){
        return sistemaVigilanciaRepository.save(habitante);
    }

    public SistemaVigilanciaExibicaoDto buscarPorId(Long id){
        Optional<SistemaVigilancia> sistemaVigilanciaOptional = sistemaVigilanciaRepository.findById(id);
        if (sistemaVigilanciaOptional.isPresent()){
            return new SistemaVigilanciaExibicaoDto(sistemaVigilanciaOptional.get());
        } else {
            throw new SistemaNaoEncontradoException("Vigilância não existente!");
        }
    }

    public List<SistemaVigilanciaExibicaoDto> listarTodos(){
        return sistemaVigilanciaRepository
                .findAll()
                .stream()
                .map(SistemaVigilanciaExibicaoDto::new)
                .toList();
    }

    ///EXCLUIR
    public void excluir(Long id){
        Optional<SistemaVigilancia> sistemaVigilanciaOptional = sistemaVigilanciaRepository.findById(id);
        if (sistemaVigilanciaOptional.isPresent()){
            sistemaVigilanciaRepository.delete(sistemaVigilanciaOptional.get());
        } else {
            throw new RuntimeException("Habitante não encontrado!");
        }
    }

    //ATUALIZAR
    public SistemaVigilancia atualizar(SistemaVigilancia sistemaVigilancia){
        Optional<SistemaVigilancia> sistemaVigilanciaOptional =
                sistemaVigilanciaRepository.findById(sistemaVigilancia.getId());

        if (sistemaVigilanciaOptional.isPresent()){
            return sistemaVigilanciaRepository.save(sistemaVigilancia);
        } else {
            throw new RuntimeException("Habitante não encontrado!");
        }
    }

}
