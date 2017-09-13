package br.com.reservaai.domain.entities.reservation;

/**
 * This enum represents the status of a reservation
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 12/09/2017
 */
public enum StatusType {

    AWAITING("status-type.awaiting"),
    CONFIRMED("status-type.confirmed"),
    REJECTED("status-type.rejected"),
    CANCELLED("status-type.cancelled");

    private final String description;

    /**
     * @param description the description for this enum
     */
    StatusType(String description) {
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
