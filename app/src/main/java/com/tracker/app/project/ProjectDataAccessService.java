package com.tracker.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDataAccessService implements ProjectDAO{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
