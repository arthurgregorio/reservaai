package br.com.reservaai.application.resources.reservation;

import br.com.reservaai.application.utils.RestPreconditions;
import br.com.reservaai.domain.entities.reservation.Reservation;
import br.com.reservaai.domain.repositories.reservation.ReservationRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

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
    private ReservationRepository reservationRepository;

    /**
     *
     * @param reservation
     */
    @ResponseBody
    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Long create(@RequestBody @Validated Reservation reservation) {
        Preconditions.checkNotNull(reservation);
        return this.reservationRepository.save(reservation).getId();
    }

    /**
     *
     * @param reservation
     */
    @ResponseStatus(OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void update(@RequestBody Reservation reservation) {
        Preconditions.checkNotNull(reservation);
        Preconditions.checkNotNull(reservation.getId());
        this.reservationRepository.save(reservation);
    }

    /**
     *
     * @param id
     */
    @ResponseBody
    @ResponseStatus(OK)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {

        final Reservation reservation = RestPreconditions.checkFound(
                this.reservationRepository.findOne(id));

        this.reservationRepository.delete(reservation);
    }

    /**
     *
     * @return
     */
    @ResponseBody
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Reservation> findAll() {
        return this.reservationRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Reservation findOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(this.reservationRepository.findOne(id));
    }
}
