package br.com.reservaai.domain.entities.reservation;

/**
 * This enum represents the state of our item
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 12/09/2017
 */
public enum ItemStatus {

    BLOCKED("item-status.blocked"),
    AVAILABLE("item-status.available"),
    UNAVAILABLE("item-status.unavailable"),
    IN_MAINTENANCE("item-status.in-maintenance");

    private final String description;

    /**
     * @param description the description for this enum
     */
    ItemStatus(String description) {
        this.description = description;
    }

    /**
     * @return the enum description
     */
    @Override
    public String toString() {
        return this.description;
    }
}
