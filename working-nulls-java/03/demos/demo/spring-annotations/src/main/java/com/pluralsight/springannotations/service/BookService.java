package com.pluralsight.springannotations.service;

import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;

@Service
public class BookService {
    @NonNull
    private Integer defaultBookId;

    private void setDefaultBookId(@NonNull Integer id) {
        this.defaultBookId = null;
    }

    @NonNull private Integer getDefaultBookId() {
        return null;
    }

    private void processBook() {
        setDefaultBookId(null);
    }
}
