package br.com.fiap.seguranca.dto;

import br.com.fiap.seguranca.model.RecursoPolicial;

import java.util.Date;

public record RecursoPolicialExibicaoDto(
        Long recurso_policial_id,

        String tipoRecurso,
        String disponibilidade,
        Long identificacao,
        String agentes,
        String delegacias,
        Long capacidae,
        Date dataAquisicao,
        Date ultimaManutencao,
        String reponsavelManutencao) {

    public RecursoPolicialExibicaoDto(RecursoPolicial recursoPolicial){
        this(
                recursoPolicial.getId(),
                recursoPolicial.getTipoRecurso(),
                recursoPolicial.getDisponibilidade(),
                recursoPolicial.getIdentificacao(),
                recursoPolicial.getAgentes(),
                recursoPolicial.getDelegacias(),
                recursoPolicial.getCapacidade(),
                recursoPolicial.getDataAquisicao(),
                recursoPolicial.getUltimaManutencao(),
                recursoPolicial.getReponsavelManutencao()
        );
    }
}

