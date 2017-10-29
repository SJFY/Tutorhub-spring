package com.tutorhub.Tutorhub.bootstrap;

import com.tutorhub.Tutorhub.model.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import com.tutorhub.Tutorhub.repositories.*;
import org.springframework.stereotype.Component;

//remember to add the component
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private CourseRepository courseRepository;
    private UserRepository userRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
    private void initData(){
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Wrox" );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        User zoe = new User("jiefeis2@illinois.edu", "Zoe", "shi");
        userRepository.save(zoe);

        Course dance = new Course("Dance 101", "Hobby", "Best ever", 10);
        courseRepository.save(dance);
    }
}