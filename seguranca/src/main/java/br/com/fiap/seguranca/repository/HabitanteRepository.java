package br.com.fiap.seguranca.repository;

import br.com.fiap.seguranca.model.Habitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitanteRepository extends JpaRepository<Habitante, Long>{

    UserDetails findByEmail(String email);
}
