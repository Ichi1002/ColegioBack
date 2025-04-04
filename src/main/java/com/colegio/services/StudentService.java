package com.colegio.services;

import com.colegio.models.Student;
import com.colegio.models.VO.Email;
import com.colegio.models.VO.NameValidator;
import com.colegio.repository.IStudentRepository;
import com.example.student.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{

    private final IStudentRepository studentRepository;
    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String country = request.getCountry();
        Student student;
        int consecutive;

        String firstPartEmail = String.format("%s.%s",
                lastName,firstName);
        List<String> emailList =  studentRepository.findEmails(firstPartEmail);

        consecutive = emailList.stream()
                .map(s -> s.split("\\."))
                .map(strings -> strings[2])
                .map(s -> s.split("@"))
                .map(strings -> strings[0])
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt)
                .max(Integer::compare)
                .orElseGet(()->0);

        student = Student.builder()
                .firstName(new NameValidator(request.getFirstName()))
                .lastName(new NameValidator(request.getLastName()))
                .country(country)
                .build();
        if (emailList.isEmpty())
            student.setEmail(Email.generateEmail(firstName, lastName, country));
        else if (emailList.size() == 1)
            student.setEmail(Email.generateEmail(firstName, lastName, country,1));
        else
            student.setEmail(Email.generateEmail(firstName, lastName, country, consecutive + 1));



        Student savedStudent = studentRepository.addStudent(student);

        AddStudentResponse addStudentResponse = new AddStudentResponse();
        addStudentResponse.setId(savedStudent.getId());
        addStudentResponse.setFirstName(savedStudent.getFirstName().getName());
        addStudentResponse.setLastName(savedStudent.getLastName().getName());
        addStudentResponse.setEmail(savedStudent.getEmail().getEmail());
        addStudentResponse.setCountry(savedStudent.getCountry());

        return addStudentResponse;
    }

    @Override
    public UpdateStudentResponse updateStudent(UpdateStudentRequest request) {
        Student updateStudent = new Student();
        updateStudent.setId(request.getId());
        updateStudent.setFirstName(new NameValidator(request.getFirstName()));
        updateStudent.setLastName(new NameValidator(request.getLastName()));
        updateStudent.setCountry(request.getCountry());

        Student savedStudent = studentRepository.updateStudent(updateStudent);
        UpdateStudentResponse response = new UpdateStudentResponse();
        response.setId(savedStudent.getId());
        response.setFirstName(savedStudent.getFirstName().getName());
        response.setLastName(savedStudent.getLastName().getName());
        response.setCountry(savedStudent.getCountry());
        response.setEmail(savedStudent.getEmail().getEmail());

        return response;
    }

    @Override
    public GetStudentResponse getStudent(GetStudentRequest request) {
        Student student = studentRepository.findStudent(request.getId());
        GetStudentResponse response = new GetStudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName().getName());
        response.setLastName(student.getLastName().getName());
        response.setEmail(student.getEmail().getEmail());
        response.setCountry(student.getCountry());
        student.getCourseList().forEach(course ->
                response.getCourse().add(course.convertCourse(course)));
        return response;
    }

    @Override
    public DeleteStudentResponse deleteStudent(DeleteStudentRequest request) {
        studentRepository.deleteStudent(request);
        DeleteStudentResponse response = new DeleteStudentResponse();
        response.setStatus(Status.SUCCESS);
        return response;
    }

    @Override
    public GetAllStudentsResponse getAllStudents(GetAllStudentsRequest request) {
        GetAllStudentsResponse response = new GetAllStudentsResponse();
        studentRepository.getAllStudents().stream()
                .map(student -> student.convertStudent(student))
                .forEach(student -> response.getStudent().add(student));

        return response;
    }
}
