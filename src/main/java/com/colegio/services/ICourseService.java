package com.colegio.services;

import com.example.student.*;

import java.util.List;

public interface ICourseService {
    GetCourseResponse getCourse(GetCourseRequest request);

    AddCourseResponse addCourse(AddCourseRequest request);

    UpdateCourseResponse updateCourse(UpdateCourseRequest request);

    DeleteCourseResponse deleteCourse(DeleteCourseRequest request);

    GetAllCoursesResponse getAllCourses(GetAllCoursesRequest request);
}
