package com.tracker.app.idea;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IdeaDataAccessService implements IdeaDAO{

    private JdbcTemplate jdbcTemplate;

    public IdeaDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
