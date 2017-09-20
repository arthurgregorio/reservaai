package br.com.reservaai.application.resources;

import br.com.reservaai.application.utils.RestPreconditions;
import br.com.reservaai.domain.entities.reservation.Reservation;
import br.com.reservaai.domain.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 13/09/2017
 */
@RestController
@RequestMapping("/reservations")
public class ReservationResource {

    @Autowired
    private ReservationService reservationService;

    /**
     *
     * @param reservation
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long create(@RequestBody @Validated Reservation reservation) {
        Preconditions.checkNotNull(reservation);
        return this.reservationService.save(reservation).getId();
    }

    public void update(@RequestBody Reservation reservation) {

    }

    /**
     *
     * @param id
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {

        final Reservation reservation = RestPreconditions.checkFound(
                this.reservationService.findReservationById(id));

        this.reservationService.delete(reservation);
    }

    /**
     *
     * @return
     */
    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reservation> findAll() {
        return this.reservationService.findAllReservations();
    }

    /**
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reservation findOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(this.reservationService.findReservationById(id));
    }
}
