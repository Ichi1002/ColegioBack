package com.colegio.repository;

import com.colegio.exception.RegistryNotFoundException;
import com.colegio.models.Course;
import com.colegio.repository.rowmapper.AllCourseRowMapper;
import com.colegio.repository.rowmapper.CourseRowMapper;
import com.example.student.DeleteCourseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseRepository implements ICourseRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Course getCourse(long id) {
        final String SELECTSQL = "select s.id,s.firstname,s.lastname,s.email,s.country,c.id as idCourse,c.coursename " +
                "from course c " +
                "left join student_course sc on sc.id_course = c.id " +
                "left join student s on s.id  = sc.id_student where c.id= :id";
        SqlParameterSource namedParametersGet = new MapSqlParameterSource()
                .addValue("id", id);
        Course course;

        try {
            course = namedParameterJdbcTemplate
                    .queryForObject(SELECTSQL, namedParametersGet, new AllCourseRowMapper());
        } catch (Exception e) {
            throw new RegistryNotFoundException("Registro no encontrado");
        }
        return course;
    }

    @Override
    public Course addCourse(Course course) {
        final String INSERTSQL = "INSERT INTO public.course " +
                "( courseName) " +
                "VALUES( :courseName);";

        final String SELECTSQL = "SELECT id, courseName " +
                " FROM public.course WHERE courseName = :courseName;";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("courseName", course.getName());
        namedParameterJdbcTemplate.update(INSERTSQL, namedParameters);

        SqlParameterSource namedParametersGet = new MapSqlParameterSource()
                .addValue("courseName", course.getName());

        return namedParameterJdbcTemplate
                .queryForObject(SELECTSQL, namedParametersGet, new CourseRowMapper());

    }


    @Override
    public Course updateCourse(Course updateCourse) {
        final String UPDATE = "UPDATE public.course " +
                "SET " +
                "courseName = COALESCE(:courseName, courseName) " +
                "WHERE id = :id;";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("courseName", updateCourse.getName())
                .addValue("id", updateCourse.getId());

        namedParameterJdbcTemplate.update(UPDATE, namedParameters);

        final String SELECTSQL = "SELECT id, courseName " +
                " FROM public.course WHERE id = :id;";
        SqlParameterSource namedParametersGet = new MapSqlParameterSource()
                .addValue("id", updateCourse.getId());
        return namedParameterJdbcTemplate
                .queryForObject(SELECTSQL, namedParametersGet, new CourseRowMapper());
    }

    @Override
    public void deleteCourse(DeleteCourseRequest request) {
        final String DELETE = "DELETE FROM public.course " +
                "WHERE id=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", request.getId());
        namedParameterJdbcTemplate.update(DELETE, namedParameters);
    }

    @Override
    public List<Course> getAllCourses() {
        final String SELECTSQL = "SELECT id, courseName FROM public.course";
        return namedParameterJdbcTemplate.query(SELECTSQL, new CourseRowMapper());
    }

}
