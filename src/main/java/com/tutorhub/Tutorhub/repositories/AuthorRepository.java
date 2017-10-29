package com.tutorhub.Tutorhub.repositories;

import com.tutorhub.Tutorhub.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
