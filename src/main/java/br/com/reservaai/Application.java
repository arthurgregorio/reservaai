package br.com.reservaai;

import br.com.reservaai.domain.entities.PersistentEntity;
import br.com.reservaai.infrastructure.spring.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * The application base class, here we start everything!
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 05/09/2017
 */
@SpringBootApplication
@EntityScan(basePackages = {
        "br.com.reservaai.domain.entities"
})
@ComponentScan(basePackages = {
        "br.com.reservaai.domain.services",
        "br.com.reservaai.domain.repositories",
        "br.com.reservaai.application.resources"
})
public class Application {

    /*
    Before start, setup the database:

    1 - Create de database owner

    CREATE USER sa_reservaai WITH
      LOGIN
      NOSUPERUSER
      INHERIT
      NOCREATEDB
      NOCREATEROLE
      NOREPLICATION;

    2 - Create the database on your postgres instance with:

    CREATE DATABASE reservaai WITH OWNER = sa_reservaai
        ENCODING = 'UTF8'
        LC_COLLATE = 'en_US.utf8'
        LC_CTYPE = 'en_US.utf8'
        CONNECTION LIMIT = -1;

    3 - Create the schemes:

    CREATE SCHEMA security
        AUTHORIZATION sa_reservaai;
    CREATE SCHEMA item
        AUTHORIZATION sa_reservaai;
    CREATE SCHEMA reservation
        AUTHORIZATION sa_reservaai;

    4 - All set! Now you can run the application!

    More on: https://github.com/arthurgregorio/reservaai/wiki
    */

    /**
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
