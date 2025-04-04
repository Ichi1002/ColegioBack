package com.colegio.services;

import com.example.student.AddStudentToCourseRequest;
import com.example.student.AddStudentToCourseResponse;
import com.example.student.RemoveStudentToCourseRequest;
import com.example.student.RemoveStudentToCourseResponse;

public interface IStudentCourseService {
    AddStudentToCourseResponse addStudentToCourse(AddStudentToCourseRequest request);

    RemoveStudentToCourseResponse removeStudentCourse(RemoveStudentToCourseRequest request);
}
