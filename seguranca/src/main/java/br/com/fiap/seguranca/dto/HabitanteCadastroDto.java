package br.com.fiap.seguranca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record HabitanteCadastroDto(
        Long habitante_id,

        @NotBlank(message = "O nome do habitante é obrigatório!")
        String nome,

        @NotBlank(message = "O gênero do habitante é obrigatório!")
        String genero,

        @NotBlank(message = "O e-mail do habitante é obrigatório!")
        String email,

        @NotBlank(message = "A senha é obrigatória!")
        @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres!")
        String senha,

        @NotBlank(message = "O endereço do habitante é obrigatório!")
        String enderecoHabitante,

        @NotBlank(message = "A data de nascimento do habitante é obrigatória!")
        Date dataNascimento,

        @NotBlank(message = "O CPF do habitante é obrigatório!")
        Long cpf,

        @NotBlank(message = "O telefone do habitante é obrigatório!")
        Long telefone
) {
}
