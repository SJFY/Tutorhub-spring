package com.tutorhub.Tutorhub.repositories;

import com.tutorhub.Tutorhub.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
