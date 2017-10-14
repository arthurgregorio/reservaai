package br.com.reservaai.domain.entities.security;

import br.com.reservaai.domain.entities.PersistentEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "roles", schema = "security")
public class Role extends PersistentEntity implements GrantedAuthority {

    @Setter
    private String authority;

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String getAuthority() {
        return this.authority;
    }
}
