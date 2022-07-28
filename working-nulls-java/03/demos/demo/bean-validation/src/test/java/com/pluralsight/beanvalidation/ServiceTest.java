package com.pluralsight.beanvalidation;

import com.pluralsight.beanvalidation.dto.BookDTO;
import com.pluralsight.beanvalidation.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private BookService service;

    @Test
    void invalidInput(){
        BookDTO book = new BookDTO();

        Exception e = assertThrows(ConstraintViolationException.class, () -> {
            service.validateBook(book);
        });
        System.out.println(e.getMessage());
    }

    @Test
    void invalidListInput(){
        BookDTO book = new BookDTO();
        book.setAuthor("author");
        book.setTitle("title");
        List<String> tags = Arrays.asList("tag1", "tag2", null);
        book.setTags(tags);

        Exception e = assertThrows(ConstraintViolationException.class, () -> {
            service.validateBook(book);
        });
        System.out.println(e.getMessage());
    }

    @Test
    void validInput() {
        BookDTO book = new BookDTO();
        book.setAuthor("author");
        book.setTitle("title");

        assertTrue(service.validateBook(book));
    }
}
