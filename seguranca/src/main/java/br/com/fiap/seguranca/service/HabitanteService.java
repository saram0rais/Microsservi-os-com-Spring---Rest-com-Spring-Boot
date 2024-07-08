package br.com.fiap.seguranca.service;

import br.com.fiap.seguranca.dto.HabitanteCadastroDto;
import br.com.fiap.seguranca.dto.HabitanteExibicaoDto;
import br.com.fiap.seguranca.exception.HabitanteNaoEncontradoException;
import br.com.fiap.seguranca.model.Habitante;
import br.com.fiap.seguranca.repository.HabitanteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Valid
public class HabitanteService {

    @Autowired
    private HabitanteRepository habitanteRepository;

    public HabitanteExibicaoDto salvarHabitante(@Valid HabitanteCadastroDto habitanteDTO){

        String senhaCriptografada = new BCryptPasswordEncoder().encode(habitanteDTO.senha());

        Habitante habitante = new Habitante();
        BeanUtils.copyProperties(habitanteDTO, habitante);

        Habitante habitanteSalvo = habitanteRepository.save(habitante);
        return new HabitanteExibicaoDto(habitanteSalvo);
    }

    public HabitanteExibicaoDto buscarPorId(Long id){
        Optional<Habitante> habitanteOptional = habitanteRepository.findById(id);
        if (habitanteOptional.isPresent()){
            return new HabitanteExibicaoDto(habitanteOptional.get());
        } else {
            throw new HabitanteNaoEncontradoException("Habitante não existe!");
        }
    }

    //LISTAR
    public List<HabitanteExibicaoDto> listarTodos(){
        return habitanteRepository
                .findAll()
                .stream()
                .map(HabitanteExibicaoDto::new)
                .toList();
    }

    ///EXCLUIR
    public void excluir(Long id){
        Optional<Habitante> habitanteOptional = habitanteRepository.findById(id);
        if (habitanteOptional.isPresent()){
            habitanteRepository.delete(habitanteOptional.get());
        } else {
            throw new RuntimeException("Habitante não encontrado!");
        }
    }

    //ATUALIZAR
    public Habitante atualizar(Habitante habitante){
        Optional<Habitante> habitanteOptional =
                habitanteRepository.findById(habitante.getId());

        if (habitanteOptional.isPresent()){
            return habitanteRepository.save(habitante);
        } else {
            throw new RuntimeException("Habitante não encontrado!");
        }
    }

}