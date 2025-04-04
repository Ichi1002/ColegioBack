package com.colegio.repository;

import com.colegio.models.Country;
import com.colegio.repository.rowmapper.CountryRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CountryRepository implements ICountryRepository{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Country> getAllCountry() {
        final String SELECT = "SELECT id,countryName,code from public.country";

        return jdbcTemplate.query(SELECT, new CountryRowMapper());
    }
}
