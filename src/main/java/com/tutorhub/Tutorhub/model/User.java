package com.tutorhub.Tutorhub.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Course teachCourse;

    @ManyToMany(mappedBy = "students")
    private Set<Course> learnCourse = new HashSet<>();



    public User(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Set<Course> getLearnCourse() {
        return learnCourse;
    }

    public void setLearnCourse(Set<Course> learnCourse) {
        this.learnCourse = learnCourse;
    }

    public Course getTeachCourse() {
        return teachCourse;
    }

    public void setTeachCourse(Course teachCourse) {
        this.teachCourse = teachCourse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User() {
    }

    public User(String firstName, String lastName, String email, Set<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.learnCourse = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", courses=" + learnCourse +
                '}';
    }
}
