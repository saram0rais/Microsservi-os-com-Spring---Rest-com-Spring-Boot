package br.com.fiap.seguranca.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record RecursoPolicialCadastroDto(
        Long recurso_policial_id,

        @NotBlank(message = "O tipo de recurso é obrigatório!")
        String tipoRecurso,

        @NotBlank(message = "O número de identificação do recurso é obrigatório!")
        Long identificacao,

        @NotBlank(message = "O nome dos agentes que estão utilizando o recurso é obrigatório!")
        String agentes,

        @NotBlank(message = "O nome das delegacias é obrigatório!")
        String delegacias,

        @NotBlank(message = "A quantidade de capacidade é obrigatória!")
        String capacidade,

        @NotBlank(message = "A data de aquisição do recurso é obrigatória!")
        Date dataAquisicao,

        @NotBlank(message = "A data da última manutenção do recurso é obrigatória!")
        Date ultimaManutencao,

        @NotBlank(message = "O nome do responsável pela manutenção do recurso é obrigatório!")
        String responsavelManutencao
) {
}
