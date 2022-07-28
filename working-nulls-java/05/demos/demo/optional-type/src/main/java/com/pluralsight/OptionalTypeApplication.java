package com.pluralsight;

import com.pluralsight.service.BookService;

import java.util.List;

public class OptionalTypeApplication {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        List<String> list = bookService.getAuthorTitlesWithReadingLevel(1);

        list.forEach(System.out::println);
    }
}
