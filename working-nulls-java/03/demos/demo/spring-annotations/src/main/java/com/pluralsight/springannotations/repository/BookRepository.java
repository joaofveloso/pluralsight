package com.pluralsight.springannotations.repository;

import org.springframework.lang.Nullable;
import com.pluralsight.springannotations.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book getByIsbn10(String isbn10);

    @Nullable Book findByIsbn10(String isbn10);

    @Nullable Book findByIsbn13(@Nullable String isbn13);

}
