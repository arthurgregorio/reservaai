package br.com.reservaai.domain.entities;

import lombok.Getter;

import javax.persistence.*;

/**
 * The abstract implementation for a persistent entity on this model
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 12/09/2017
 */
@MappedSuperclass
public abstract class PersistentEntity implements IPersistentEntity<Long> {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public boolean isSaved() {
        return this.id != null && this.id != 0;
    }
}
