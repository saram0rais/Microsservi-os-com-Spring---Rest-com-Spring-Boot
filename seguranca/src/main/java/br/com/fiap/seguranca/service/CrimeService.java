package br.com.fiap.seguranca.service;

import br.com.fiap.seguranca.dto.CrimeExibicaoDto;
import br.com.fiap.seguranca.exception.CrimeNaoEncontradoException;
import br.com.fiap.seguranca.model.Crime;
import br.com.fiap.seguranca.repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrimeService {

    @Autowired
    private CrimeRepository crimeRepository;

    //SALVAR
    public Crime salvarCrime(Crime crime){
        return crimeRepository.save(crime);
    }

    //BUSCAR
    public CrimeExibicaoDto buscarPorId(Long id){
        Optional<Crime> crimeOptional = crimeRepository.findById(id);
        if (crimeOptional.isPresent()){
            return new CrimeExibicaoDto(crimeOptional.get());
        } else {
            throw new CrimeNaoEncontradoException("Crime não existente!");
        }
    }

    public List<CrimeExibicaoDto> listarTodos(){
        return crimeRepository
                .findAll()
                .stream()
                .map(CrimeExibicaoDto::new)
                .toList();
    }

    ///EXCLUIR
    public void excluir(Long id){
        Optional<Crime> crimeOptional = crimeRepository.findById(id);
        if (crimeOptional.isPresent()){
            crimeRepository.delete(crimeOptional.get());
        } else {
            throw new RuntimeException("Crime não existente!");
        }
    }

    //ATUALIZAR
    public Crime atualizar(Crime crime){
        Optional<Crime> crimeOptional =
                crimeRepository.findById(crime.getId());

        if (crimeOptional.isPresent()){
            return crimeRepository.save(crime);
        } else {
            throw new RuntimeException("Crime não existente!");
        }
    }

}
