package br.com.fiap.seguranca.dto;

import br.com.fiap.seguranca.model.Emergencia;
import java.util.Date;

public record EmergenciaExibicaoDto(
        Long emergencia_id,
        String tipo,
        String descricao,
        Date dataEmergencia,
        String localizacao,
        String status) {

    public EmergenciaExibicaoDto(Emergencia emergencia) {
        this(
                emergencia.getId(),
                emergencia.getTipoEmergencia(),
                emergencia.getDescricao(),
                emergencia.getDataEmergencia(),
                emergencia.getLocalizacao(),
                emergencia.getStatus());
    }
}
