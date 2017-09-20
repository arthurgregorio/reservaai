package br.com.reservaai.domain.services;

import br.com.reservaai.domain.entities.reservation.Reservation;
import br.com.reservaai.domain.repositories.reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 13/09/2017
 */
@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    /**
     *
     * @param reservation
     * @return
     */
    public Reservation update(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    /**
     *
     * @param reservation
     */
    public void delete(Reservation reservation) {
        this.reservationRepository.delete(reservation);
    }

    /**
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<Reservation> findAllReservations() {
        return this.reservationRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Reservation findReservationById(long id) {
        return this.reservationRepository.findOne(id);
    }
}
