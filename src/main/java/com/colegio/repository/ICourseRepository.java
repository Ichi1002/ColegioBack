package com.colegio.repository;

import com.colegio.models.Course;
import com.example.student.DeleteCourseRequest;
import com.example.student.GetCourseRequest;

import java.util.List;

public interface ICourseRepository {
    Course getCourse(long id);
    Course addCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(DeleteCourseRequest request);

    List<Course> getAllCourses();
}
