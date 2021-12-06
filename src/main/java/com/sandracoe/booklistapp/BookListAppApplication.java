package com.sandracoe.booklistapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing; 

@SpringBootApplication
@EnableJpaAuditing
public class BookListAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookListAppApplication.class, args);
	}

}
