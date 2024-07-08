package br.com.fiap.seguranca.dto;

import br.com.fiap.seguranca.model.Crime;

import java.util.Date;

public record CrimeExibicaoDto(
        Long crime_id,
        String nomeCrime,
        String tipoCrime,
        String localizacao,
        String status,
        String gravidade,
        String armaUtilizada,
        String descricao,
        Date dataCrime) {

    public CrimeExibicaoDto(Crime crime) {
        this(
                crime.getId(),
                crime.getNomeCrime(),
                crime.getTipoCrime(),
                crime.getLocalizacao(),
                crime.getStatus(),
                crime.getGravidade(),
                crime.getArmaUtilizada(),
                crime.getDescricao(),
                crime.getDataCrime()
        );
    }
}
