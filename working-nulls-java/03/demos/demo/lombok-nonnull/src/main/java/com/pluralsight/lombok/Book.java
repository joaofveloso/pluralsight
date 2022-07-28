package com.pluralsight.lombok;

import lombok.NonNull;

public class Book {
    private String title;

    public Book(@NonNull String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Book book = new Book(null);
        System.out.println(book);
    }
}
