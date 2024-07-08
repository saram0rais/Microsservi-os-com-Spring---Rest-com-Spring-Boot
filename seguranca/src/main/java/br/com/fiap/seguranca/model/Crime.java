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
@Table(name = "T_CRIME")
@NoArgsConstructor
@AllArgsConstructor
public class Crime implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CRIME"
    )
    @SequenceGenerator(
            name = "SEQ_CRIME",
            sequenceName = "SEQ_CRIME",
            allocationSize = 1
    )
    @Column(name = "crime_id")
    private Long id;

    private String nomeCrime;
    private String tipoCrime;
    private Date dataCrime;
    private String localizacao;
    private String status;
    private String gravidade;
    private String armaUtilizada;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private CrimeRole role;

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCrime() {
        return nomeCrime;
    }

    public void setNomeCrime(String nomeCrime) {
        this.nomeCrime = nomeCrime;
    }

    public String getTipoCrime() {
        return tipoCrime;
    }

    public void setTipoCrime(String tipoCrime) {
        this.tipoCrime = tipoCrime;
    }

    public Date getDataCrime() {
        return dataCrime;
    }

    public void setDataCrime(Date dataCrime) {
        this.dataCrime = dataCrime;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public String getArmaUtilizada() {
        return armaUtilizada;
    }

    public void setArmaUtilizada(String armaUtilizada) {
        this.armaUtilizada = armaUtilizada;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crime crime = (Crime) o;
        return Objects.equals(id, crime.id) && Objects.equals(nomeCrime, crime.nomeCrime) && Objects.equals(tipoCrime, crime.tipoCrime) && Objects.equals(dataCrime, crime.dataCrime) && Objects.equals(localizacao, crime.localizacao) && Objects.equals(status, crime.status) && Objects.equals(gravidade, crime.gravidade) && Objects.equals(armaUtilizada, crime.armaUtilizada) && Objects.equals(descricao, crime.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCrime, tipoCrime, dataCrime, localizacao, status, gravidade, armaUtilizada, descricao);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == CrimeRole.ADMIN) {
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



