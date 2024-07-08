package br.com.fiap.seguranca.repository;

import br.com.fiap.seguranca.model.Crime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrimeRepository extends JpaRepository<Crime, Long> {

}
