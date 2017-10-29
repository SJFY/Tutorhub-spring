package com.tutorhub.Tutorhub.repositories;

import com.tutorhub.Tutorhub.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
