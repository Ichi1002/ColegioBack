package com.colegio.repository.rowmapper;

import com.colegio.models.Student;
import com.colegio.models.VO.Email;
import com.colegio.models.VO.NameValidator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();

        student.setId(rs.getInt("id"));
        student.setFirstName(new NameValidator(rs.getString("firstname")));
        student.setLastName(new NameValidator(rs.getString("lastname")));
        student.setEmail(new Email(rs.getString("email")));
        student.setCountry(rs.getString("country"));

        return student;
    }
}
