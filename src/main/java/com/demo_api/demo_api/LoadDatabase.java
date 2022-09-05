package com.demo_api.demo_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository){
        return args ->{
            log.info("Preloading" + repository.save(new Employee("Employee #1", "HR Recruiter")));
            log.info("Preloading" + repository.save(new Employee("Employee #2", "IT technician")));
            log.info("Preloading" + repository.save(new Employee("Employee #3", "COO")));
            log.info("Preloading" + repository.save(new Employee("Employee #4", "CEO")));
        };
    }
}

// Spring Boot corre todos los beans cuando el contexto de la applicacion sea cargado 
// CommandLineRuner solicita una copia del repositorio en EmployeeRepository.java 
// Usandolo, creara 4 entidades y las guardara.
