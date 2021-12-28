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

    @Override
    public void addIdea(Idea idea){
        String sql = """
                INSERT INTO idea (summary, details, priority, user_id ) VALUES (?, ?, ?, ?);
                """;
        jdbcTemplate.update(sql, idea.getSummary(), idea.getDetails(), idea.getPriority(), idea.getUserId());
    }
}
