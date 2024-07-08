package br.com.fiap.seguranca.service;

import br.com.fiap.seguranca.dto.RecursoPolicialExibicaoDto;
import br.com.fiap.seguranca.exception.RecursoNaoEncontradoException;
import br.com.fiap.seguranca.model.RecursoPolicial;
import br.com.fiap.seguranca.repository.RecursoPolicialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoPolicialService {

    @Autowired
    private RecursoPolicialRepository recursoPolicialRepository;

    //SALVAR
    public RecursoPolicial salvarRecurso(RecursoPolicial recursoPolicial){
        return recursoPolicialRepository.save(recursoPolicial);
    }

    //BUSCAR
    public RecursoPolicialExibicaoDto buscarPorId(Long id){
        Optional<RecursoPolicial> recursoPolicialOptional = recursoPolicialRepository.findById(id);
        if (recursoPolicialOptional.isPresent()){
            return new RecursoPolicialExibicaoDto(recursoPolicialOptional.get());
        } else {
            throw new RecursoNaoEncontradoException("Recurso não existente!");
        }
    }

    public List<RecursoPolicialExibicaoDto> listarTodos(){
        return recursoPolicialRepository
                .findAll()
                .stream()
                .map(RecursoPolicialExibicaoDto::new)
                .toList();
    }

    ///EXCLUIR
    public void excluir(Long id){
        Optional<RecursoPolicial> recursoPolicialOptional = recursoPolicialRepository.findById(id);
        if (recursoPolicialOptional.isPresent()){
            recursoPolicialRepository.delete(recursoPolicialOptional.get());
        } else {
            throw new RuntimeException("Recurso não existente!");
        }
    }

    //ATUALIZAR
    public RecursoPolicial atualizar(RecursoPolicial recursoPolicial){
        Optional<RecursoPolicial> recursoPolicialOptional =
                recursoPolicialRepository.findById(recursoPolicial.getId());

        if (recursoPolicialOptional.isPresent()){
            return recursoPolicialRepository.save(recursoPolicial);
        } else {
            throw new RuntimeException("Recurso não existente!");
        }
    }

}
