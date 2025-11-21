package com.ligabeisbolcartagena.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(
    basePackages = "com.ligabeisbolcartagena.main.repository.mysql", // solo repos JPA
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "transactionManager"
)
@EnableMongoRepositories(
    basePackages = "com.ligabeisbolcartagena.main.repository.mongo", // solo repos Mongo
    mongoTemplateRef = "mongoTemplate"
)
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
