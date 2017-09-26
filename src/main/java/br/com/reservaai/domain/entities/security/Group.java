package br.com.reservaai.domain.entities.security;

import br.com.reservaai.domain.entities.PersistentEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 26/09/2017
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "groups", schema = "security")
public class Group extends PersistentEntity {

    private String name;
    private String description;

    @Getter
    @Setter
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Role> roles;
}
