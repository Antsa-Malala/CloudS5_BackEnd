package org.project.clouds5_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"org.project.clouds5_backend.repository"})
public class CloudS5BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudS5BackEndApplication.class, args);
    }

}
