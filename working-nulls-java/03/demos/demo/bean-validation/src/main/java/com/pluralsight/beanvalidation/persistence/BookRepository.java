package com.pluralsight.beanvalidation.persistence;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
