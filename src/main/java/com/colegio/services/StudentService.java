package com.colegio.services;

import com.colegio.exception.CharacterNotValidException;
import com.colegio.exception.InvalidLengthException;
import com.colegio.models.Student;
import com.colegio.models.VO.Email;
import com.colegio.models.VO.NameValidator;
import com.colegio.repository.IStudentRepository;
import com.example.student.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) {
        AddStudentResponse addStudentResponse = new AddStudentResponse();

        try {
            String firstName = request.getFirstName();
            String lastName = request.getLastName();
            String country = request.getCountry();
            Student student;
            int consecutive;

            String firstPartEmail = String.format("%s.%s",
                    lastName, firstName);
            List<String> emailList = studentRepository.findEmails(firstPartEmail);

            consecutive = emailList.stream()
                    .map(s -> s.split("\\."))
                    .map(strings -> strings[2])
                    .map(s -> s.split("@"))
                    .map(strings -> strings[0])
                    .filter(s -> s.matches("\\d+"))
                    .map(Integer::parseInt)
                    .max(Integer::compare)
                    .orElseGet(() -> 0);

            student = Student.builder()
                    .firstName(new NameValidator(request.getFirstName()))
                    .lastName(new NameValidator(request.getLastName()))
                    .country(country)
                    .build();
            if (emailList.isEmpty())
                student.setEmail(Email.generateEmail(firstName, lastName, country));
            else if (emailList.size() == 1)
                student.setEmail(Email.generateEmail(firstName, lastName, country, 1));
            else
                student.setEmail(Email.generateEmail(firstName, lastName, country, consecutive + 1));


            Student savedStudent = studentRepository.addStudent(student);
            addStudentResponse.setId(savedStudent.getId());
            addStudentResponse.setFirstName(savedStudent.getFirstName().getName());
            addStudentResponse.setLastName(savedStudent.getLastName().getName());
            addStudentResponse.setEmail(savedStudent.getEmail().getEmail());
            addStudentResponse.setCountry(savedStudent.getCountry());
        } catch (CharacterNotValidException | InvalidLengthException e) {
            Fault fault = new Fault();
            Fault.Detail detail = new Fault.Detail();
            detail.setErrorCode(404);
            detail.setErrorMessage(e.getMessage());
            fault.setFaultstring("soap:Client");
            fault.setFaultcode("Cartacteres no validos");
            fault.setDetail(detail);

            addStudentResponse.setFault(fault);
        }


        return addStudentResponse;
    }

    @Override
    public UpdateStudentResponse updateStudent(UpdateStudentRequest request) {
        UpdateStudentResponse response = new UpdateStudentResponse();
        try {
            Student updateStudent = new Student();
            updateStudent.setId(request.getId());
            updateStudent.setFirstName(new NameValidator(request.getFirstName()));
            updateStudent.setLastName(new NameValidator(request.getLastName()));
            updateStudent.setCountry(request.getCountry());

            Student savedStudent = studentRepository.updateStudent(updateStudent);

            response.setId(savedStudent.getId());
            response.setFirstName(savedStudent.getFirstName().getName());
            response.setLastName(savedStudent.getLastName().getName());
            response.setCountry(savedStudent.getCountry());
            response.setEmail(savedStudent.getEmail().getEmail());
        } catch (CharacterNotValidException | InvalidLengthException e) {
            Fault fault = new Fault();
            Fault.Detail detail = new Fault.Detail();
            detail.setErrorCode(404);
            detail.setErrorMessage(e.getMessage());
            fault.setFaultstring("soap:Client");
            fault.setFaultcode("Caracteres no validos");
            fault.setDetail(detail);
            response.setFault(fault);
        }
        return response;
    }

    @Override
    public GetStudentResponse getStudent(GetStudentRequest request) {
        GetStudentResponse response = new GetStudentResponse();
        try {
            Student student = studentRepository.findStudent(request.getId());
            response.setId(student.getId());
            response.setFirstName(student.getFirstName().getName());
            response.setLastName(student.getLastName().getName());
            response.setEmail(student.getEmail().getEmail());
            response.setCountry(student.getCountry());
            student.getCourseList().forEach(course ->
                    response.getCourse().add(course.convertCourse(course)));
        } catch (Exception e) {
            Fault fault = new Fault();
            Fault.Detail detail = new Fault.Detail();
            detail.setErrorCode(404);
            detail.setErrorMessage("El estudiante con el ID proporcionado no existe.");
            fault.setFaultstring("soap:Client");
            fault.setFaultcode("Estudiante no encontrado");
            fault.setDetail(detail);

            response.setFault(fault);
        }

        return response;
    }

    @Override
    public DeleteStudentResponse deleteStudent(DeleteStudentRequest request) {

        DeleteStudentResponse response = new DeleteStudentResponse();
        try {
            studentRepository.deleteStudent(request);
            return response;
        } catch (Exception e) {
            Fault fault = new Fault();
            Fault.Detail detail = new Fault.Detail();
            detail.setErrorCode(404);
            detail.setErrorMessage("No se puede borrar el estudiante.");
            fault.setFaultstring("soap:Client");
            fault.setFaultcode("El estudiante tiene cursos asociados");
            fault.setDetail(detail);
            response.setFault(fault);
        }
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
