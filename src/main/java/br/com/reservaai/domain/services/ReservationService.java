package br.com.reservaai.domain.services;

import br.com.reservaai.domain.repositories.reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 13/09/2017
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


}
