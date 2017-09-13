package br.com.reservaai.domain.entities.item;

/**
 * This enum represents the type of a item state
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 12/09/2017
 */
public enum StateType {

    BLOCKED("state-type.blocked"),
    AVAILABLE("state-type.available"),
    UNAVAILABLE("state-type.unavailable"),
    IN_MAINTENANCE("state-type.in-maintenance");

    private final String description;

    /**
     * @param description the description for this enum
     */
    StateType(String description) {
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
