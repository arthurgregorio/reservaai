package br.com.reservaai.domain.entities.security;

import br.com.reservaai.domain.entities.PersistentEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

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

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "groups_roles", schema = "security",
            joinColumns = {
                @JoinColumn(name = "fk_group", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "fk_role", nullable = false, updatable = false)
            })
    private Set<Role> roles;
}
