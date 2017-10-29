package com.tutorhub.Tutorhub.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private String description;
    private int price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_course", joinColumns = @JoinColumn(name = "course_name"),
        inverseJoinColumns = @JoinColumn(name = "teacher_name"))
    private User teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_course", joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<User> students = new HashSet<>();

    public Course(String name, String category, String description, int price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public Course(String name, String category, String description, int price, User teacher, Set<User> users) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.teacher = teacher;
        this.students = users;
    }

    public Set<User> getStudents() {
        return students;
    }

    public void setStudents(Set<User> students) {
        this.students = students;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Course() {
    }

    public Course(String name, String category, String description, int price, Set<User> users) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.students = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return id != null ? id.equals(course.id) : course.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", users=" + students +
                '}';
    }
}
