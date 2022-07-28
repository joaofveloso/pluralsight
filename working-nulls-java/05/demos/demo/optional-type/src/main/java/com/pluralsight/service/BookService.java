package com.pluralsight.service;

import com.pluralsight.model.Book;
import com.pluralsight.model.ReadingLevel;
import com.pluralsight.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BookService {
    private BookRepository bookRepository = new BookRepository();

    public List<String> getAuthorTitlesWithReadingLevel(Integer authorId) {
        List<Book> books = bookRepository.findByAuthorId(authorId);
        List<String> titlesWithReadingLevel = new ArrayList<>();

        books.forEach(
                book -> titlesWithReadingLevel.add(
                        book.getReadingLevel()
                                .map(readingLevel -> book.getTitle() + " - " + readingLevel)
                                .orElse(book.getTitle() + " - " + "No reading level set")
                )
        );

        return titlesWithReadingLevel;
    }

    /*public List<String> getAuthorTitlesWithReadingLevel(Integer authorId) {
        List<Book> books = bookRepository.findByAuthorId(authorId);
        List<String> titlesWithReadingLevel = new ArrayList<>();

        books.forEach(
                book -> titlesWithReadingLevel.add(
                            book.getTitle()
                                    + " - "
                                + formatReadingLevelDescription(book.getReadingLevel())
                )
        );

        return titlesWithReadingLevel;
    }*/

    /*private String formatReadingLevelDescription(Optional<ReadingLevel> optionalReadingLevel) {
        return optionalReadingLevel
                .map(readingLevel -> readingLevel.toString())
                .orElse("No reading level set");
    }*/
}
