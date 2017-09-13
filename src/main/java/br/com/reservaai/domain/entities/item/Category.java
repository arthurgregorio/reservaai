package br.com.reservaai.domain.entities.item;

import br.com.reservaai.domain.entities.PersistentEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The types of items we can reserve
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 12/09/2017
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "categories", schema = "item")
public class Category extends PersistentEntity {

    @Getter
    @Setter
    @Column(name = "name", length = 90, nullable = false)
    private String name;
    @Getter
    @Setter
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
