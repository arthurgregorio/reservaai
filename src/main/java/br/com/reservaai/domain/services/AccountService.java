package br.com.reservaai.domain.services;

import br.com.reservaai.domain.entities.security.User;
import br.com.reservaai.domain.repositories.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 24/10/2017
 */
@Service
@Transactional
public class AccountService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * {@inheritDoc}
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> userOptional = this.userRepository.findByUsername(username);
        return userOptional.orElseThrow(() -> new UsernameNotFoundException("authentication.user-not-found"));
    }
}
