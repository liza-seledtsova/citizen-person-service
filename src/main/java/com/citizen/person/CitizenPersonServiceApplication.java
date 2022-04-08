package com.citizen.person;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The main class Citizen person service application.
 */
@SpringBootApplication
@EnableJpaRepositories(
        basePackages = "com.citizen.person.repository", repositoryImplementationPostfix = "CustomImpl")
@OpenAPIDefinition(info = @Info(title = "Person API", version = "1.0", description = "Person Information"))
public class CitizenPersonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitizenPersonServiceApplication.class, args);
    }

}
