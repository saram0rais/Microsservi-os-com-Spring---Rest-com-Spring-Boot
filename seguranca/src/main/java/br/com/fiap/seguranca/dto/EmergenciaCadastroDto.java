package br.com.fiap.seguranca.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record EmergenciaCadastroDto(
        Long emergencia_id,

        @NotBlank(message = "O tipo de emergência é obrigatório!")
        String tipo,

        @NotBlank(message = "A data da emergência é obrigatória!")
        Date dataEmergencia,

        @NotBlank(message = "A localização da emergência é obrigatória!")
        String localizacao,

        @NotBlank(message = "O status da emergência é obrigatório!")
        String status

) {
}
