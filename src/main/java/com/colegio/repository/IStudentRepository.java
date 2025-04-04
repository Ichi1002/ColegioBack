package com.colegio.repository;

import com.colegio.models.Student;
import com.example.student.DeleteStudentRequest;

import java.util.Arrays;
import java.util.List;

public interface IStudentRepository {
    Student addStudent(Student student);

    List<String> findEmails(String firstPartEmail);

    Student updateStudent(Student updateStudent);

    Student findStudent(long id);

    void deleteStudent(DeleteStudentRequest request);

    List<Student> getAllStudents();
}
