package com.tutorhub.Tutorhub.bootstrap;

import com.tutorhub.Tutorhub.model.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import com.tutorhub.Tutorhub.repositories.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//remember to add the component
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CourseRepository courseRepository;
    private UserRepository userRepository;

    public DevBootstrap(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        User zoe = new User("jiefeis2@illinois.edu", "Zoe", "shi");

        User Fangxiaozhi = new User("fyu10@illinois.edu", "Fangxiaozhi", "Yu");
        User will = new User("ws@gmail.com", "Will", "Smith");




        Course java = new Course("Java Spring framework", "Home", "Best ever", 100);
        Course dance = new Course("Dance 101", "Hobby", "Best ever", 10);
//        zoe.setCourse(dance);
//        dance.setTeacher(zoe);

        dance.setTeacher(zoe);
        zoe.setTeachCourse(dance);



        dance.getStudents().add(zoe);
       java.getStudents().add(zoe);
        java.getStudents().add(Fangxiaozhi);
        java.getStudents().add(will);

//        zoe.getLearnCourse().add(java);
//        zoe.getLearnCourse().add(dance);
//        Fangxiaozhi.getLearnCourse().add(java);
//        will.getLearnCourse().add(java);


        java.setTeacher(zoe);
        zoe.setTeachCourse(java);

        courseRepository.save(dance);
        userRepository.save(zoe);
        courseRepository.save(java);
        userRepository.save(Fangxiaozhi);
        userRepository.save(will);
    }
}
