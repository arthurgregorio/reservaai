package br.com.reservaai.application.resources;

import br.com.reservaai.domain.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 13/09/2017
 */
@RestController
public class ReservationResource {

    @Autowired
    private ReservationService reservationService;
}
