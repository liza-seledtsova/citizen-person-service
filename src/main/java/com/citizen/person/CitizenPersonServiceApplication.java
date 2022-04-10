package com.citizen.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The main class Citizen person service application.
 */
@SpringBootApplication
@EnableJpaRepositories
public class CitizenPersonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitizenPersonServiceApplication.class, args);
    }

}
