package br.com.fiap.seguranca.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record CrimeCadastroDto(
        Long crime_id,

        @NotBlank(message = "O nome do crime é obrigatório!")
        String nomeCrime,

        @NotBlank(message = "O tipo de crime é obrigatório!")
        String tipoCrime,

        @NotBlank(message = "A localização do crime é obrigatória!")
        String localizacao,

        @NotBlank(message = "O status do crime é obrigatório!")
        String status,

        @NotBlank(message = "A gravidade de crime é obrigatória!")
        String gravidade,

        @NotBlank(message = "O nome da arma utilizada é obrigatório!")
        String armaUtilizada,

        @NotBlank(message = "A data do crime é obrigatória!")
        Date dataCrime
) {
}
