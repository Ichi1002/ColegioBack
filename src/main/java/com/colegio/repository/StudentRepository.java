package com.colegio.repository;

import com.colegio.models.Student;
import com.colegio.repository.rowmapper.AllStudentRowMapper;
import com.colegio.repository.rowmapper.StudentRowMapper;
import com.example.student.DeleteStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentRepository implements IStudentRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Student addStudent(Student student) {
        final String INSERTSQL = "INSERT INTO public.student " +
                "( firstname, lastname, email, country) " +
                "VALUES( :firstname, :lastname, :email, :country);";

        final String SELECTSQL = "SELECT id, firstname, lastname, email, country " +
                " FROM public.student WHERE email = :email;";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("firstname", student.getFirstName().getName())
                .addValue("lastname", student.getLastName().getName())
                .addValue("email", student.getEmail().getEmail())
                .addValue("country", student.getCountry());


        namedParameterJdbcTemplate.update(INSERTSQL, namedParameters);

        SqlParameterSource namedParametersGet = new MapSqlParameterSource()
                .addValue("email", student.getEmail().getEmail());

        return namedParameterJdbcTemplate
                .queryForObject(SELECTSQL, namedParametersGet, new StudentRowMapper());

    }

    @Override
    public List<String> findEmails(String firstPartEmail) {
        String param = firstPartEmail.concat("%").toUpperCase();
        final String SELECT = "SELECT email FROM public.student WHERE email LIKE (:email);";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("email", param);
        return namedParameterJdbcTemplate.queryForList(SELECT, namedParameters,String.class);
    }

    @Override
    public Student updateStudent(Student updateStudent) {
        final String UPDATE = "UPDATE public.student " +
                "SET " +
                "firstname = COALESCE(:firstname, firstname), " +
                "lastname = COALESCE(:lastname, lastname), " +
                "country = COALESCE(:country, country) " +
                "WHERE id = :id;";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("firstname", updateStudent.getFirstName().getName())
                .addValue("lastname", updateStudent.getLastName().getName())
                .addValue("country", updateStudent.getCountry())
                .addValue("id", updateStudent.getId());
            namedParameterJdbcTemplate.update(UPDATE,namedParameters);

        final String SELECTSQL = "SELECT id, firstname, lastname, email, country " +
                " FROM public.student WHERE id = :id;";
        SqlParameterSource namedParametersGet = new MapSqlParameterSource()
                .addValue("id", updateStudent.getId());
        return namedParameterJdbcTemplate
                .queryForObject(SELECTSQL, namedParametersGet, new StudentRowMapper());
    }

    @Override
    public Student findStudent(long id) {
        final String SELECTSQL = "select s.id,s.firstname,s.lastname,s.email,s.country,c.id as courseid,c.coursename from student s " +
                "left join student_course sc on sc.id_student = s.id " +
                "left join course c on c.id  = sc.id_course " +
                "WHERE s.id = :id";
        SqlParameterSource namedParametersGet = new MapSqlParameterSource()
                .addValue("id", id);

        return namedParameterJdbcTemplate
                .queryForObject(SELECTSQL, namedParametersGet, new AllStudentRowMapper());
    }

    @Override
    public void deleteStudent(DeleteStudentRequest request) {
        final String DELETE = "DELETE FROM public.student " +
                "WHERE id=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", request.getId());
        namedParameterJdbcTemplate.update(DELETE, namedParameters);
    }

    @Override
    public List<Student> getAllStudents() {
        final String SELECTSQL = "SELECT id, firstname, lastname, email, country FROM public.student";
        return namedParameterJdbcTemplate
                .query(SELECTSQL, new StudentRowMapper());
    }
}
