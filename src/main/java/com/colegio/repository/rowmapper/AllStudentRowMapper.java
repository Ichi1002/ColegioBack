package com.colegio.repository.rowmapper;

import com.colegio.models.Course;
import com.colegio.models.Student;
import com.colegio.models.VO.Email;
import com.colegio.models.VO.NameValidator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class AllStudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();

        student.setId(rs.getInt("id"));
        student.setFirstName(new NameValidator(rs.getString("firstname")));
        student.setLastName(new NameValidator(rs.getString("lastname")));
        student.setEmail(new Email(rs.getString("email")));
        student.setCountry(rs.getString("country"));

        Set<Course> courses = new HashSet<>();
            do {
                Course course = new Course();
                course.setId(rs.getLong("courseid"));
                course.setName(rs.getString("coursename"));
                courses.add(course);
            } while (rs.next());
        student.setCourseList(courses);
        return student;
    }
}
