package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student("Mariam", "mariam@example.com",
                    LocalDate.of(2000, Month.JANUARY, 5));
            Student alex =
                    new Student("Alex", "alex@example.com", LocalDate.of(2004, Month.JANUARY, 5));
            Student delores = new Student("Delores", "delores@example.com",
                    LocalDate.of(2002, Month.JANUARY, 5));

            repository.saveAll(List.of(mariam, alex, delores));

        };

    }
}
