package com.colegio.repository;

import com.example.student.AddStudentToCourseRequest;
import com.example.student.AddStudentToCourseResponse;
import com.example.student.RemoveStudentToCourseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudentCourseRepository implements IStudentCourseRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void addStudentToCourse(AddStudentToCourseRequest request) {
        final String SQL = "INSERT INTO public.student_course " +
                "(id_student, id_course) " +
                "VALUES(:idStudent, :idCourse);";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("idStudent", request.getIdStudent())
                .addValue("idCourse", request.getIdCourse());
        namedParameterJdbcTemplate.update(SQL, namedParameters);
    }
@Override
    public void removeStudentToCourse(RemoveStudentToCourseRequest request) {
        final String SQL = "DELETE FROM public.student_course " +
                "WHERE id_student=:idStudent AND id_course=:idCourse;";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("idStudent", request.getIdStudent())
                .addValue("idCourse", request.getIdCourse());
        namedParameterJdbcTemplate.update(SQL, namedParameters);
    }
}
