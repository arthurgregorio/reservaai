package br.com.reservaai.domain.entities.reservation;

import br.com.reservaai.domain.entities.PersistentEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 13/09/2017
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "status", schema = "reservation")
public class Status extends PersistentEntity {

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
    @Column(name = "status_type", nullable = false)
    private StatusType statusType;

    /**
     *
     */
    public Status() {
        this.statusType = StatusType.AWAITING;
    }
}
