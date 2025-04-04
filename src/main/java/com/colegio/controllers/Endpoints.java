package com.colegio.controllers;

import com.colegio.services.ICountryService;
import com.colegio.services.ICourseService;
import com.colegio.services.IStudentCourseService;
import com.colegio.services.IStudentService;
import com.example.student.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
@RequiredArgsConstructor
public class Endpoints {

    private static final Logger logger = LoggerFactory.getLogger(Endpoints.class);
    private static final String NAMESPACE_URI = "http://www.example.com/student";

    private final ICourseService courseService;
    private final IStudentService studentService;
    private final IStudentCourseService studentCourseService;
    private final ICountryService countryService;
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCourseRequest")
    @ResponsePayload
    public GetCourseResponse getCourse(@RequestPayload GetCourseRequest request) {
        logger.info("Solicitud para obtener el curso con id: {}",request.getId());
        return courseService.getCourse(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCoursesRequest")
    @ResponsePayload
    public GetAllCoursesResponse getAllCourses(@RequestPayload GetAllCoursesRequest request) {
        logger.info("Solicitud para obtener todos los cursos");
        return courseService.getAllCourses(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllStudentsRequest")
    @ResponsePayload
    public GetAllStudentsResponse getAllStudents(@RequestPayload GetAllStudentsRequest request) {
        logger.info("Solicitud para obtener todos los estudiantes");
        return studentService.getAllStudents(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCourseRequest")
    @ResponsePayload
    public AddCourseResponse addCourse(@RequestPayload AddCourseRequest request) {
        logger.info("Solicitud para añadir un curso {}:",request);
        return courseService.addCourse(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCourseRequest")
    @ResponsePayload
    public UpdateCourseResponse addStudent(@RequestPayload UpdateCourseRequest request) {
        logger.info("Solicitud para actualizar el curso {}:",request);
        return courseService.updateCourse(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCourseRequest")
    @ResponsePayload
    public DeleteCourseResponse deleteSCourse(@RequestPayload DeleteCourseRequest request) {
        logger.info("Solicitud para eliminar el curso con id {}:",request.getId());
        return courseService.deleteCourse(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addStudentRequest")
    @ResponsePayload
    public AddStudentResponse addStudent(@RequestPayload AddStudentRequest request) {
        logger.info("Solicitud para añadir un estudiante {}:",request);
        return studentService.addStudent(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateStudentRequest")
    @ResponsePayload
    public UpdateStudentResponse addStudent(@RequestPayload UpdateStudentRequest request) {
        logger.info("Solicitud para actualizar un estudiante {}:",request);
        return studentService.updateStudent(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
    @ResponsePayload
    public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
        logger.info("Solicitud para obtener el estudiante con id : {}:",request.getId());
        return studentService.getStudent(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteStudentRequest")
    @ResponsePayload
    public DeleteStudentResponse deleteStudent(@RequestPayload DeleteStudentRequest request) {
        logger.info("Solicitud para borrar el estudiante con id {}:",request.getId());
        return studentService.deleteStudent(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addStudentToCourseRequest")
    @ResponsePayload
    public AddStudentToCourseResponse addStudentToCourse(@RequestPayload AddStudentToCourseRequest request) {
        logger.info("Solicitud para añadir un estudiante con id {} al curso con id {}:",
                request.getIdStudent(),request.getIdCourse());
        return studentCourseService.addStudentToCourse(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeStudentToCourseRequest")
    @ResponsePayload
    public RemoveStudentToCourseResponse removeStudentToCourse(@RequestPayload RemoveStudentToCourseRequest request) {
        logger.info("Solicitud para elimina el estudiante con id {} al curso con id {}:",
                request.getIdStudent(),request.getIdCourse());
        return studentCourseService.removeStudentCourse(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryListRequest")
    @ResponsePayload
    public GetCountryListResponse getCountryListRequest() {
        logger.info("Solicitud para obtner todos los paises");
        return countryService.getAllCountry();
    }
}