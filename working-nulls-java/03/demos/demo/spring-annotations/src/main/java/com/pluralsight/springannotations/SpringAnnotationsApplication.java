package com.pluralsight.springannotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAnnotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAnnotationsApplication.class, args);
	}

	/*@Bean
	CommandLineRunner init(BookRepository repository) {
		return args -> {
			String isbn = "1234567899";

			System.out.println( repository.getByIsbn10(isbn) );
		};
	}*/
}
