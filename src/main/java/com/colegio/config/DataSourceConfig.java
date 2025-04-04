package com.colegio.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceConfig {

    @Value("${datasource.url}")
    private String URL;
    @Value("${datasource.username}")
    private String USER;
    @Value("${datasource.password}")
    private String PASS;
    @Value("${datasource.driver}")
    private String DRIVER ;
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName(DRIVER)
                .url(URL)
                .username(USER)
                .password(PASS)
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
