package com.pluralsight.beanvalidation.service;

import com.pluralsight.beanvalidation.dto.BookDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class BookService {

    public boolean validateBook(@Valid BookDTO book) {
        return true;
    }
}
