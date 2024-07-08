package br.com.fiap.seguranca.dto;

import br.com.fiap.seguranca.model.Habitante;

import java.util.Date;

public record HabitanteExibicaoDto(
    Long habitante_id,
    String nome,
    String genero,
    String email,
    String senha,
    String enderecoHabitante,
    Date dataNascimento,
    Long cpf,
    Long telefone,
    String observacoes,
    String historicoCriminal) {

    public HabitanteExibicaoDto(Habitante habitante){
        this(
                habitante.getId(),
                habitante.getNome(),
                habitante.getGenero(),
                habitante.getEmail(),
                habitante.getSenha(),
                habitante.getEnderecoHabitante(),
                habitante.getDataNascimento(),
                habitante.getCpf(),
                habitante.getTelefone(),
                habitante.getObservacoes(),
                habitante.getHistoricoCriminal()
        );
    }
}
