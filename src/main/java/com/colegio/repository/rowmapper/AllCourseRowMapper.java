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

public class AllCourseRowMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course course = new Course();
        course.setId(rs.getLong("idcourse"));
        course.setName(rs.getString("courseName"));
        Set<Student> students = new HashSet<>();
            do {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirstName(new NameValidator(rs.getString("firstname")));
                student.setLastName(new NameValidator(rs.getString("lastname")));
                student.setEmail(new Email(rs.getString("email")));
                student.setCountry(rs.getString("country"));
                students.add(student);
            } while (rs.next());

        course.setStudentList(students);

        return course;
    }
}
