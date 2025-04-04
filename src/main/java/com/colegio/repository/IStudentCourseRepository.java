package com.colegio.repository;

import com.example.student.AddStudentToCourseRequest;
import com.example.student.AddStudentToCourseResponse;
import com.example.student.RemoveStudentToCourseRequest;

public interface IStudentCourseRepository {
    void addStudentToCourse(AddStudentToCourseRequest request);
    void removeStudentToCourse(RemoveStudentToCourseRequest request);
}
