package br.com.reservaai.domain.entities.item;

import br.com.reservaai.application.utils.RandomCodeGenerator;
import br.com.reservaai.domain.entities.PersistentEntity;
import br.com.reservaai.domain.entities.reservation.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * The representation of the items that can be reserved
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 12/09/2017
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "items", schema = "item")
public class Item extends PersistentEntity {

    @Getter
    @Column(name = "code", length = 4, nullable = false, unique = true)
    private String code;
    @Getter
    @Setter
    @Column(name = "name", length = 90, nullable = false)
    private String name;
    @Getter
    @Setter
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "fk_state")
    private State state;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "fk_category")
    private Category category;

    /**
     *
     */
    public Item() {
        this.code = RandomCodeGenerator.numericCode(4);
    }
}
