package com.colegio.services;

import com.colegio.models.Course;
import com.colegio.repository.ICourseRepository;
import com.example.student.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final ICourseRepository courseRepository;

    @Override
    public GetCourseResponse getCourse(GetCourseRequest request) {
        Course course = courseRepository.getCourse(request.getId());
        GetCourseResponse response = new GetCourseResponse();
        response.setId(course.getId());
        response.setName(course.getName());
        course.getStudentList().forEach(student ->
                response.getStudent().add(student.convertStudent(student)));
        return response;
    }

    @Override
    public AddCourseResponse addCourse(AddCourseRequest request) {
        Course course = new Course();
        course.setName(request.getName());
        Course courseSaved = courseRepository.addCourse(course);
        AddCourseResponse response = new AddCourseResponse();
        response.setId(courseSaved.getId());
        response.setName(courseSaved.getName());
        return response;
    }

    @Override
    public UpdateCourseResponse updateCourse(UpdateCourseRequest request) {
        Course course = new Course();
        course.setId(request.getId());
        course.setName(request.getName());

        Course savedCourse = courseRepository.updateCourse(course);
        UpdateCourseResponse response = new UpdateCourseResponse();
        response.setId(savedCourse.getId());
        response.setName(savedCourse.getName());

        return response;
    }

    @Override
    public DeleteCourseResponse deleteCourse(DeleteCourseRequest request) {
        courseRepository.deleteCourse(request);
        DeleteCourseResponse response = new DeleteCourseResponse();
        response.setStatus(Status.SUCCESS);
        return response;
    }

    @Override
    public GetAllCoursesResponse getAllCourses(GetAllCoursesRequest request) {
        GetAllCoursesResponse response = new GetAllCoursesResponse();
        courseRepository.getAllCourses().stream()
                .map(course -> course.convertCourse(course))
                .forEach(course -> response.getCourse().add(course));

        return response;
    }
}

