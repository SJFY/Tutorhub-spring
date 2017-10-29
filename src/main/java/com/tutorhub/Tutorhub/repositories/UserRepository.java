package com.tutorhub.Tutorhub.repositories;

import com.tutorhub.Tutorhub.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
