package br.com.reservaai.application.utils;

import br.com.reservaai.domain.exceptions.ResourceNotFoundException;

import java.util.Collection;
import java.util.Objects;

/**
 * Helper class to centralize some of the common code used in all rest resources of the application
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 19/09/2017
 */
public final class RestPreconditions {

    /**
     * After a findSomething action use this method to check if the query returned the desired data
     *
     * @param <T> the generic type of this data
     *
     * @param object the data we want to check if is present
     * @return if the data is found, return him to de caller method
     */
    public static <T> T checkFound(final T object) {
        if (Objects.isNull(object)) {
            throw new ResourceNotFoundException();
        }
        return object;
    }

    /**
     * The same functionality of {@link #checkFound(Object)} but this time for collections, checking not only if the
     * data is not null but if the collection is empty or not
     *
     * @param <T> the type of the collection
     * @param object the data to check
     * @return if the data is found, return him to de caller method
     */
    public static <T extends Collection> T checkFound(final T object) {
        if (!Objects.isNull(object)) {
            final Collection<?> collection = (Collection<?>) object;
            if (!collection.isEmpty()) {
                return object;
            }
        }
        throw new ResourceNotFoundException();
    }
}
