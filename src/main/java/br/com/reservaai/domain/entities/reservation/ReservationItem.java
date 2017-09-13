package br.com.reservaai.domain.entities.reservation;

import br.com.reservaai.domain.entities.PersistentEntity;
import br.com.reservaai.domain.entities.item.Item;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class represents the connection between reservation and the item, its like a many-to-many aggregation table
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 05/09/2017
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "reservation_items", schema = "reservation")
public class ReservationItem extends PersistentEntity {

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "fk_item")
    private Item item;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "fk_reservation")
    private Reservation reservation;

    /**
     * Base constructor...
     */
    public ReservationItem() { }

    /**
     * Helper constructor to create a well initialized instance of this class
     *
     * @param item the item of this reference
     * @param reservation the reservation to refer to this item
     */
    public ReservationItem(Item item, Reservation reservation) {
        this.item = item;
        this.reservation = reservation;
    }

    /**
     * Check if this relation is about a specific item
     *
     * @param item the item to be checked
     * @return true if yes, false otherwise
     */
    public boolean isForItem(Item item) {
        return this.item.equals(item);
    }
}
