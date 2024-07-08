package br.com.fiap.seguranca.repository;

import br.com.fiap.seguranca.model.Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergenciaRepository extends JpaRepository<Emergencia, Long> {
}
