package com.pluralsight.books;

import org.springframework.boot.SpringApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSpringDataWebSupport
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

}

