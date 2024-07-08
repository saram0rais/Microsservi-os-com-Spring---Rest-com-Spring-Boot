package br.com.fiap.seguranca.dto;

import br.com.fiap.seguranca.model.SistemaVigilancia;

import java.util.Date;

public record SistemaVigilanciaExibicaoDto(
        Long sistema_vigilancia_id,
        String nomeSistema,
        String localizacao,
        String descricao,
        String status,
        String resolucaoVideo,
        Date ultimaManutencao,
        String responsaveManutencao,
        String registroIncidentes) {

    public SistemaVigilanciaExibicaoDto (SistemaVigilancia sistemaVigilancia){
        this(
                sistemaVigilancia.getId(),
                sistemaVigilancia.getNomeSistema(),
                sistemaVigilancia.getLocalizacao(),
                sistemaVigilancia.getDescricao(),
                sistemaVigilancia.getStatus(),
                sistemaVigilancia.getResolucaoVideo(),
                sistemaVigilancia.getUltimaManutencao(),
                sistemaVigilancia.getResponsaveManutencao(),
                sistemaVigilancia.getRegistroIncidentes()
        );
    }
}
