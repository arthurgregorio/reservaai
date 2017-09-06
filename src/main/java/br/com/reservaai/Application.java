package br.com.reservaai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The application base class, here we start everything!
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 05/09/2017
 */
@SpringBootApplication
public class Application {

    /**
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
