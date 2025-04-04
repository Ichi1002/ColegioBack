package com.colegio.models;

import lombok.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private long id;
    private String name;
    private Set<Student> studentList;

    public Course(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public com.example.student.Course convertCourse(Course course){
        com.example.student.Course courses = new com.example.student.Course();
        courses.setId(course.getId());
        courses.setName(course.getName());
        return courses;
    }
}
