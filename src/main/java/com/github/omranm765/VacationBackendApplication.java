package com.github.omranm765;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VacationBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(VacationBackendApplication.class, args);
        System.out.println("Server started");
    }
}
