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
@Table(name = "T_EMERGENCIA")
@NoArgsConstructor
@AllArgsConstructor
public class Emergencia implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_EMERGENCIAS"
    )
    @SequenceGenerator(
            name = "SEQ_EMERGENCIAS",
            sequenceName = "SEQ_EMERGENCIAS",
            allocationSize = 1
    )
    @Column(name = "emergencia_id")
    private Long id;

    private String tipoEmergencia;
    private Date dataEmergencia;
    private String localizacao;

    private String descricao;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_habitante")
    private Habitante habitante;

    @ManyToOne
    @JoinColumn(name = "id_sistema")
    private SistemaVigilancia sistemaVigilancia;

    @Enumerated(EnumType.STRING)
    private EmergenciaRole role;

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(String tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }

    public Date getDataEmergencia() {
        return dataEmergencia;
    }

    public void setDataEmergencia(Date dataEmergencia) {
        this.dataEmergencia = dataEmergencia;
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

    public Habitante getHabitante() {
        return habitante;
    }

    public void setHabitante(Habitante habitante) {
        this.habitante = habitante;
    }

    public SistemaVigilancia getSistemaVigilancia() {
        return sistemaVigilancia;
    }

    public void setSistemaVigilancia(SistemaVigilancia sistemaVigilancia) {
        this.sistemaVigilancia = sistemaVigilancia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emergencia that = (Emergencia) o;
        return Objects.equals(id, that.id) && Objects.equals(tipoEmergencia, that.tipoEmergencia) && Objects.equals(dataEmergencia, that.dataEmergencia) && Objects.equals(localizacao, that.localizacao) && Objects.equals(descricao, that.descricao) && Objects.equals(status, that.status) && Objects.equals(habitante, that.habitante) && Objects.equals(sistemaVigilancia, that.sistemaVigilancia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoEmergencia, dataEmergencia, localizacao, descricao, status, habitante);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == EmergenciaRole.ADMIN) {
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
