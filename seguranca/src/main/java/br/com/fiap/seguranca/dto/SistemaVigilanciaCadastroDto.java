package br.com.fiap.seguranca.dto;

import jakarta.validation.constraints.NotBlank;

public record SistemaVigilanciaCadastroDto(
        Long sistema_vigilancia_id,

        @NotBlank(message = "O nome do sistema de vigilância é obrigatório!")
        String nomeSistema,

        @NotBlank(message = "A localização da câmera do sistema de vigilância é obrigatória!")
        String localizacao,

        @NotBlank(message = "O status do sistema de vigilância é obrigatório!")
        String status,

        @NotBlank(message = "A data da última manutenção das câmeras é obrigatória!")
        String ultimaManutencao,

        @NotBlank(message = "O nome do responsável pela manutenção do sistema de vigilância é obrigatório!")
        String responsavelManutencao
) {
}
