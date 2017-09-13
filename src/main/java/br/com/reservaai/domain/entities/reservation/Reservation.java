package br.com.reservaai.domain.entities.reservation;

import br.com.reservaai.application.utils.RandomCodeGenerator;
import br.com.reservaai.domain.entities.PersistentEntity;
import br.com.reservaai.domain.entities.item.Item;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The representation of a reservationItems reservation
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 05/09/2017
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "reservations", schema = "reservation")
public class Reservation extends PersistentEntity {

    @Getter
    @Column(name = "code", length = 6, nullable = false, unique = true)
    private String code;
    @Getter
    @Setter
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Getter
    @Setter
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @Getter
    @Setter
    @Column(name = "end_time", nullable = false)
    private LocalTime startTime;
    @Getter
    @Setter
    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "fk_status")
    private Status status;

    @Transient
    private Set<ReservationItem> reservationItems;

    /**
     *
     */
    public Reservation() {

        this.code = RandomCodeGenerator.alphanumericCode(6);

        this.startDate = LocalDate.now();
        this.endDate = LocalDate.now();

        this.reservationItems = Collections.emptySet();
    }

    /**
     * Use this method to add a item in this reservation
     *
     * @param item the item to be add in this reservation
     */
    public void addItem(Item item) {
        this.reservationItems.add(new ReservationItem(item, this));
    }

    /**
     * Use this method to remove a item form this reservation
     *
     * @param item the item to remove
     */
    public void removeItem(Item item) {
        this.reservationItems = this.reservationItems.stream()
                .filter(ri -> ri.isForItem(item))
                .collect(Collectors.toSet());
    }
}