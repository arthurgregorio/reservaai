package br.com.reservaai.domain.entities.reservation;

import br.com.reservaai.application.utils.RandomCodeGenerator;
import br.com.reservaai.domain.entities.PersistentEntity;
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
@Table(name = "items", schema = "reservation")
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
    @Enumerated(EnumType.STRING)
    @Column(name = "item_status", nullable = false)
    private ItemStatus itemStatus;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "fk_item_type")
    private ItemType itemType;

    /**
     *
     */
    public Item() {
        this.code = RandomCodeGenerator.numericCode(4);
    }
}
