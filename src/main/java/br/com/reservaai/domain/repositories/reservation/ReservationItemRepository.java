package br.com.reservaai.domain.repositories.reservation;

import br.com.reservaai.domain.entities.reservation.ReservationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 05/09/2017
 */
@Repository
public interface ReservationItemRepository extends JpaRepository<ReservationItem, Long> {

}
