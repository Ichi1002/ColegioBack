package com.colegio.services;

import com.colegio.repository.IStudentCourseRepository;
import com.example.student.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentCourseService implements IStudentCourseService {
    private final IStudentCourseRepository studentCourseRepository;
    @Override
    public AddStudentToCourseResponse addStudentToCourse(AddStudentToCourseRequest request) {
        studentCourseRepository.addStudentToCourse(request);
        AddStudentToCourseResponse response = new AddStudentToCourseResponse();
        response.setStatus(Status.SUCCESS);
        return response;
    }

    @Override
    public RemoveStudentToCourseResponse removeStudentCourse(RemoveStudentToCourseRequest request) {
        studentCourseRepository.removeStudentToCourse(request);
        RemoveStudentToCourseResponse response = new RemoveStudentToCourseResponse();
        response.setStatus(Status.SUCCESS);
        return response;
    }
}
