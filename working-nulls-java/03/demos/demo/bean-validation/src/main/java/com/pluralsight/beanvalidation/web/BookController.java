package com.pluralsight.beanvalidation.web;

import com.pluralsight.beanvalidation.dto.BookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BookController {

    @PostMapping("/book")
    ResponseEntity<String> book(@Valid @RequestBody BookDTO input) {
        return ResponseEntity.ok("ok");
    }

}
