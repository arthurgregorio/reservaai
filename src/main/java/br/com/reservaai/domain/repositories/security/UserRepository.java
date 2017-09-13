package br.com.reservaai.domain.repositories.security;

import br.com.reservaai.domain.entities.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 05/09/2017
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
