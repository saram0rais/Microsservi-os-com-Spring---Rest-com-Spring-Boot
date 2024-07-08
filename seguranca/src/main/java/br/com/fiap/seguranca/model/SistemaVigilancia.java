package br.com.fiap.seguranca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "T_SISTEMA_VIGILANCIA")
@NoArgsConstructor
@AllArgsConstructor
public class SistemaVigilancia implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_SISTEMA_VIGILANCIA"
    )
    @SequenceGenerator(
            name = "SEQ_SISTEMA_VIGILANCIA",
            sequenceName = "SEQ_SISTEMA_VIGILANCIA",
            allocationSize = 1
    )
    @Column(name = "sistema_vigilancia_id")
    private Long id;

    private String nomeSistema;
    private String localizacao;
    private String descricao;
    private String status;
    private byte[] video;
    private String resolucaoVideo;
    private Date ultimaManutencao;
    private String responsaveManutencao;
    private String registroIncidentes;

    @Enumerated(EnumType.STRING)
    private SistemaVigilanciaRole role;


    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSistema() {
        return nomeSistema;
    }

    public void setNomeSistema(String nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public String getResolucaoVideo() {
        return resolucaoVideo;
    }

    public void setResolucaoVideo(String resolucaoVideo) {
        this.resolucaoVideo = resolucaoVideo;
    }

    public Date getUltimaManutencao() {
        return ultimaManutencao;
    }

    public void setUltimaManutencao(Date ultimaManutencao) {
        this.ultimaManutencao = ultimaManutencao;
    }

    public String getResponsaveManutencao() {
        return responsaveManutencao;
    }

    public void setResponsaveManutencao(String responsaveManutencao) {
        this.responsaveManutencao = responsaveManutencao;
    }

    public String getRegistroIncidentes() {
        return registroIncidentes;
    }

    public void setRegistroIncidentes(String registroIncidentes) {
        this.registroIncidentes = registroIncidentes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SistemaVigilancia that = (SistemaVigilancia) o;
        return Objects.equals(nomeSistema, that.nomeSistema) && Objects.equals(localizacao, that.localizacao) && Objects.equals(descricao, that.descricao) && Objects.equals(status, that.status) && Objects.deepEquals(video, that.video) && Objects.equals(resolucaoVideo, that.resolucaoVideo) && Objects.equals(ultimaManutencao, that.ultimaManutencao) && Objects.equals(responsaveManutencao, that.responsaveManutencao) && Objects.equals(registroIncidentes, that.registroIncidentes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeSistema, localizacao, descricao, status, Arrays.hashCode(video), resolucaoVideo, ultimaManutencao, responsaveManutencao, registroIncidentes);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == SistemaVigilanciaRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE.USER")
            );
        } else {
            return List.of(
                    new SimpleGrantedAuthority("ROLE.USER"));
        }
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
