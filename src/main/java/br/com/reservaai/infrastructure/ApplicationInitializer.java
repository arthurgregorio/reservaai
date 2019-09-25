package br.com.reservaai.infrastructure;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Class to initialize the basic data for our application.
 *
 * With this class the system can ensure the admin user is on the database and even if ou delete him, another one
 * will be created on the startup of the application and his password will be printed on the console
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 31/10/2017
 */
@Component
public class ApplicationInitializer implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * {@inheritDoc}
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {


    }
}
