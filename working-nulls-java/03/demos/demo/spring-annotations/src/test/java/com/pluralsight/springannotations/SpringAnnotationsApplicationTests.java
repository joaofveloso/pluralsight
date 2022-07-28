package com.pluralsight.springannotations;

import com.pluralsight.springannotations.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SpringAnnotationsApplicationTests {

	@Autowired
	private BookRepository repository;

	@Test
	void testGetQueryNoResultThrowsException() {
		assertThrows( EmptyResultDataAccessException.class, () -> {
			repository.getByIsbn10("invalid isbn");
		});
	}

	@Test
	void testGetQueryNullArgumentThrowsException() {
		assertThrows( IllegalArgumentException.class, () -> {
			repository.getByIsbn10(null);
		});
	}

	@Test
	void testFindQueryNoResultReturnsNull() {
		assertNull( repository.findByIsbn10("invalid isbn") );
	}

	@Test
	void testFindQueryNullArgumentThrowsException() {
		assertThrows( IllegalArgumentException.class, () -> {
			repository.findByIsbn10(null);
		});
	}

	@Test
	void testFindQueryNullArgumentAndNullReturn() {
		assertNull( repository.findByIsbn13(null) );
	}

}
