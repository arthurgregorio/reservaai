package br.com.reservaai.application.utils;

import br.com.reservaai.domain.exceptions.ResourceNotFoundException;

import java.util.Objects;

/**
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 19/09/2017
 */
public final class RestPreconditions {

    /**
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> T checkFound(final T object) {
        if (Objects.isNull(object)) {
            throw new ResourceNotFoundException();
        }
        return object;
    }
}
