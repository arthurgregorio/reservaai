package br.com.reservaai;

import br.com.reservaai.domain.entities.PersistentEntity;
import br.com.reservaai.infrastructure.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Persistent;

/**
 * The application base class, here we start everything!
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 05/09/2017
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = Configuration.class)
@EntityScan(basePackageClasses = PersistentEntity.class)
public class Application {

    /**
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
