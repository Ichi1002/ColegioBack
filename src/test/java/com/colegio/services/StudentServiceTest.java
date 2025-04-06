package com.colegio.services;

import com.colegio.models.Student;
import com.colegio.models.VO.Email;
import com.colegio.models.VO.NameValidator;
import com.colegio.repository.IStudentRepository;
import com.example.student.AddStudentRequest;
import com.example.student.AddStudentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @MockBean
    IStudentRepository iStudentRepository;
    @Autowired
    StudentService studentService;

    @BeforeEach
    void setUp(){
        iStudentRepository = mock(IStudentRepository.class);
        studentService = new StudentService(iStudentRepository);
    }

    @Test
    void should_add_a_Student() {
        Student studentRequest = new Student();
        studentRequest.setId(1L);
        studentRequest.setFirstName(new NameValidator("JHON"));
        studentRequest.setLastName(new NameValidator("PEREZ"));
        studentRequest.setCountry("CO");
        studentRequest.setEmail(new Email("PEREZ.JHOE@FASTTRACK.COM.CO"));
        when(iStudentRepository.addStudent(any(Student.class))).thenReturn(studentRequest);
        when(iStudentRepository.findEmails(anyString())).thenReturn(new ArrayList<>());


        AddStudentRequest request = new AddStudentRequest();
        request.setFirstName("JHON");
        request.setLastName("PEREZ");
        request.setCountry("CO");
        AddStudentResponse response = studentService.addStudent(request);

        AddStudentResponse expectedResponse = new AddStudentResponse();
        expectedResponse.setId(1L);
        expectedResponse.setFirstName("JHON");
        expectedResponse.setLastName("PEREZ");
        expectedResponse.setCountry("CO");
        expectedResponse.setEmail("PEREZ.JHOE@FASTTRACK.COM.CO");

        assertEquals(expectedResponse.getId(),response.getId());
        assertEquals(expectedResponse.getFirstName(),response.getFirstName());
        assertEquals(expectedResponse.getLastName(),response.getLastName());
        assertEquals(expectedResponse.getCountry(),response.getCountry());
        assertEquals(expectedResponse.getEmail(),response.getEmail());
    }

    @Test
    void should_add_a_1_to_email_student() {
        Student studentRequest = new Student();
        studentRequest.setId(1L);
        studentRequest.setFirstName(new NameValidator("JHON"));
        studentRequest.setLastName(new NameValidator("PEREZ"));
        studentRequest.setCountry("CO");
        studentRequest.setEmail(new Email("PEREZ.JHOE.1@FASTTRACK.COM.CO"));
        when(iStudentRepository.addStudent(any(Student.class))).thenReturn(studentRequest);
        when(iStudentRepository.findEmails(anyString())).thenReturn(List.of("PEREZ.JHOE@FASTTRACK.COM.CO"));


        AddStudentRequest request = new AddStudentRequest();
        request.setFirstName("JHON");
        request.setLastName("PEREZ");
        request.setCountry("CO");
        AddStudentResponse response = studentService.addStudent(request);

        AddStudentResponse expectedResponse = new AddStudentResponse();
        expectedResponse.setId(1L);
        expectedResponse.setFirstName("JHON");
        expectedResponse.setLastName("PEREZ");
        expectedResponse.setCountry("CO");
        expectedResponse.setEmail("PEREZ.JHOE.1@FASTTRACK.COM.CO");

        assertEquals(expectedResponse.getId(),response.getId());
        assertEquals(expectedResponse.getFirstName(),response.getFirstName());
        assertEquals(expectedResponse.getLastName(),response.getLastName());
        assertEquals(expectedResponse.getCountry(),response.getCountry());
        assertEquals(expectedResponse.getEmail(),response.getEmail());
    }

    @Test
    void should_add_the_next_number_to_email_student() {
        Student studentRequest = new Student();
        studentRequest.setId(1L);
        studentRequest.setFirstName(new NameValidator("JHON"));
        studentRequest.setLastName(new NameValidator("PEREZ"));
        studentRequest.setCountry("CO");
        studentRequest.setEmail(new Email("PEREZ.JHOE.9@FASTTRACK.COM.CO"));
        when(iStudentRepository.addStudent(any(Student.class))).thenReturn(studentRequest);
        when(iStudentRepository.findEmails(anyString())).thenReturn(
                List.of("PEREZ.JHOE.5@FASTTRACK.COM.CO",
                        "PEREZ.JHOE.8@FASTTRACK.COM.CO"));


        AddStudentRequest request = new AddStudentRequest();
        request.setFirstName("JHON");
        request.setLastName("PEREZ");
        request.setCountry("CO");
        AddStudentResponse response = studentService.addStudent(request);

        AddStudentResponse expectedResponse = new AddStudentResponse();
        expectedResponse.setId(1L);
        expectedResponse.setFirstName("JHON");
        expectedResponse.setLastName("PEREZ");
        expectedResponse.setCountry("CO");
        expectedResponse.setEmail("PEREZ.JHOE.9@FASTTRACK.COM.CO");

        assertEquals(expectedResponse.getId(),response.getId());
        assertEquals(expectedResponse.getFirstName(),response.getFirstName());
        assertEquals(expectedResponse.getLastName(),response.getLastName());
        assertEquals(expectedResponse.getCountry(),response.getCountry());
        assertEquals(expectedResponse.getEmail(),response.getEmail());
    }
}