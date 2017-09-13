package br.com.reservaai.domain.entities;

import java.io.Serializable;

/**
 * The contract to represent a persistent entity in this model
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 12/09/2017
 */
public interface IPersistentEntity<T extends Serializable> {

    /**
     * @return the id of this persistent entity
     */
    T getId();

    /**
     * @return if this entity is saved or not
     */
    boolean isSaved();
}