package com.pluralsight.beanvalidation;

import com.pluralsight.beanvalidation.persistence.BookEntity;
import com.pluralsight.beanvalidation.persistence.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void invalidInput() {
        BookEntity book = new BookEntity();

        Exception e = assertThrows(ConstraintViolationException.class, () -> {
            repository.save(book);
            entityManager.flush();
        });
        System.out.println(e.getMessage());
    }

    @Test
    void validInput() {
        BookEntity book = new BookEntity();
        book.setAuthor("author");
        book.setTitle("title");

        BookEntity savedBook = repository.save(book);
        entityManager.flush();

        Optional<BookEntity> newBook = repository.findById(savedBook.getId());
        assertTrue(newBook.isPresent());
    }
}
