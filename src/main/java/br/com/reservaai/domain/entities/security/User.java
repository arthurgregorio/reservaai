package br.com.reservaai.domain.entities.security;

import br.com.reservaai.domain.entities.PersistentEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

/**
 * The representation of the ones who uses this system, their users
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 12/09/2017
 */
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "users", schema = "security")
public class User extends PersistentEntity implements UserDetails {

    @Getter
    @Setter
    @Column(name = "name", length = 90, nullable = false)
    private String name;
    @Getter
    @Setter
    @Column(name = "username", length = 16, nullable = false)
    private String username;
    @Getter
    @Setter
    @Column(name = "password", length = 256, nullable = false)
    private String password;
    @Getter
    @Setter
    @Column(name = "expired", nullable = false)
    private boolean expired;
    @Getter
    @Setter
    @Column(name = "blocked", nullable = false)
    private boolean blocked;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "fk_group")
    private Group group;

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Collection<Role> getAuthorities() {
        return this.group.getRoles();
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return !this.expired;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return !this.blocked;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return !this.expired;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return !this.blocked;
    }
}
