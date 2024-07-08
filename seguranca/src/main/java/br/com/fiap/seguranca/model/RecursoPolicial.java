package br.com.fiap.seguranca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_RECURSOS_POLICIAIS")
@NoArgsConstructor
@AllArgsConstructor
public class RecursoPolicial implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_RECURSOS_POLICIAIS"
    )
    @SequenceGenerator(
            name = "SEQ_RECURSOS_POLICIAIS",
            sequenceName = "SEQ_RECURSOS_POLICIAIS",
            allocationSize = 1
    )
    @Column(name = "recursos_policiais_id")
    private Long id;

    private String tipoRecurso;
    private String disponibilidade;
    private Long identificacao;
    private String localizacaoAtual;
    private String agentes;
    private String delegacias;
    private int capacidade;
    private Date dataAquisicao;
    private Date ultimaManutencao;
    private String reponsavelManutencao;

    @ManyToOne
    @JoinColumn(name = "recurso_policial_id")
    private Emergencia emergencia;

    @Enumerated(EnumType.STRING)
    private RecursoPolicialRole role;

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Long getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Long identificacao) {
        this.identificacao = identificacao;
    }

    public String getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    public void setLocalizacaoAtual(String localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
    }

    public String getAgentes() {
        return agentes;
    }

    public void setAgentes(String agentes) {
        this.agentes = agentes;
    }

    public String getDelegacias() {
        return delegacias;
    }

    public void setDelegacias(String delegacias) {
        this.delegacias = delegacias;
    }

    public long getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Date getUltimaManutencao() {
        return ultimaManutencao;
    }

    public void setUltimaManutencao(Date ultimaManutencao) {
        this.ultimaManutencao = ultimaManutencao;
    }

    public String getReponsavelManutencao() {
        return reponsavelManutencao;
    }

    public void setReponsavelManutencao(String reponsavelManutencao) {
        this.reponsavelManutencao = reponsavelManutencao;
    }

    public Emergencia getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(Emergencia emergencia) {
        this.emergencia = emergencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursoPolicial that = (RecursoPolicial) o;
        return capacidade == that.capacidade && Objects.equals(id, that.id) && Objects.equals(tipoRecurso, that.tipoRecurso) && Objects.equals(disponibilidade, that.disponibilidade) && Objects.equals(identificacao, that.identificacao) && Objects.equals(localizacaoAtual, that.localizacaoAtual) && Objects.equals(agentes, that.agentes) && Objects.equals(delegacias, that.delegacias) && Objects.equals(dataAquisicao, that.dataAquisicao) && Objects.equals(ultimaManutencao, that.ultimaManutencao) && Objects.equals(reponsavelManutencao, that.reponsavelManutencao) && Objects.equals(emergencia, that.emergencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoRecurso, disponibilidade, identificacao, localizacaoAtual, agentes, delegacias, capacidade, dataAquisicao, ultimaManutencao, reponsavelManutencao, emergencia);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == RecursoPolicialRole.ADMIN) {
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
