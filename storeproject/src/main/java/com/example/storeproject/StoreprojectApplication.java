package com.example.storeproject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.storeproject.repositories")
public class StoreprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoreprojectApplication.class, args);
	}
	}


