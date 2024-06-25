package com.example.example_meilisearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExampleMeilisearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleMeilisearchApplication.class, args);
	}

}
