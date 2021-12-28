package com.tracker.app.idea;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IdeaDataAccessService implements IdeaDAO{

    private JdbcTemplate jdbcTemplate;

    public IdeaDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Idea> getAllIdeas(){
        String sql = """
                SELECT * FROM ideas;
                """;

        List<Idea> ideasList = jdbcTemplate.query(sql, new IdeaRowMapper());
        return ideasList;
    }
}
