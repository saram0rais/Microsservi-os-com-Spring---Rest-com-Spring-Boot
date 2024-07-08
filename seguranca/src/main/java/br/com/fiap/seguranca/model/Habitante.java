package br.com.fiap.seguranca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name= "T_HABITANTE")
@NoArgsConstructor
@AllArgsConstructor
public class Habitante implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_HABITANTES"
    )
    @SequenceGenerator(
            name = "SEQ_HABITANTES",
            sequenceName = "SEQ_HABITANTES",
            allocationSize = 1
    )
    @Column(name = "habitante_id")
    private Long id;

    private String nome;
    private String genero;
    private String email;
    private String senha;
    private String enderecoHabitante;
    private Date dataNascimento;
    private Long cpf;
    private Long telefone;
    private byte[] foto;


    private String observacoes;
    private String historicoCriminal;

    @Enumerated(EnumType.STRING)
    private HabitanteRole role;

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.genero = email;
    }

    public String getEnderecoHabitante() {
        return enderecoHabitante;
    }

        public void setSenha(String senha) {
        this.genero = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setEnderecoHabitante(String enderecoHabitante) {
        this.enderecoHabitante = enderecoHabitante;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getHistoricoCriminal() {
        return historicoCriminal;
    }

    public void setHistoricoCriminal(String historicoCriminal) {
        this.historicoCriminal = historicoCriminal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitante habitante = (Habitante) o;
        return Objects.equals(id, habitante.id) && Objects.equals(nome, habitante.nome) && Objects.equals(genero, habitante.genero) && Objects.equals(email, habitante.email) && Objects.equals(senha, habitante.senha) && Objects.equals(enderecoHabitante, habitante.enderecoHabitante) && Objects.equals(dataNascimento, habitante.dataNascimento) && Objects.equals(cpf, habitante.cpf) && Objects.equals(telefone, habitante.telefone) && Objects.deepEquals(foto, habitante.foto) && Objects.equals(observacoes, habitante.observacoes) && Objects.equals(historicoCriminal, habitante.historicoCriminal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, genero, email, senha, enderecoHabitante, dataNascimento, cpf, telefone, Arrays.hashCode(foto), observacoes, historicoCriminal);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == HabitanteRole.ADMIN) {
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
