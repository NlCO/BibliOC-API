package fr.nlco.biblioc.bibliocapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BibliocapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliocapiApplication.class, args);
    }

}
