package com.colegio.repository.rowmapper;

import com.colegio.models.Country;
import com.colegio.models.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        Country country = new Country();
        country.setId(rs.getLong("id"));
        country.setName(rs.getString("countryName"));
        country.setCode(rs.getString("code"));

        return country;
    }
}
