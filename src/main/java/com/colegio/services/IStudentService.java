package com.colegio.services;

import com.example.student.*;

public interface IStudentService {
    AddStudentResponse addStudent(AddStudentRequest request);

    UpdateStudentResponse updateStudent(UpdateStudentRequest request);

    GetStudentResponse getStudent(GetStudentRequest request);
    DeleteStudentResponse deleteStudent(DeleteStudentRequest request);

    GetAllStudentsResponse getAllStudents(GetAllStudentsRequest request);
}
