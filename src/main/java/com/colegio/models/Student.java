package com.colegio.models;

import com.colegio.models.VO.Email;
import com.colegio.models.VO.NameValidator;
import com.example.student.Country;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private long id;
    private NameValidator firstName;
    private NameValidator lastName;
    private String country;
    private Email email;
    private Set<Course> courseList;

    public com.example.student.Student convertStudent(Student student){
        com.example.student.Student students = new com.example.student.Student();
        students.setId(student.getId());
        students.setFirstName(student.getFirstName().getName());
        students.setLastName(student.getLastName().getName());
        students.setEmail(student.getEmail().getEmail());
        students.setCountry(student.getCountry());
        return students;
    }
}
