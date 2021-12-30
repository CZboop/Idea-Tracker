package com.tracker.app.idea;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IdeaDataAccessService implements IdeaDAO{

    private JdbcTemplate jdbcTemplate;
    private IdeaRowMapper ideaRowMapper;

    public IdeaDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.ideaRowMapper = new IdeaRowMapper();
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

    @Override
    public void updateIdea(Idea idea){
        String sql = """
                UPDATE idea SET summary = ?, details = ?, priority = ?, user_id = ? WHERE id = ?;
                """;
        jdbcTemplate.update(sql, idea.getSummary(), idea.getDetails(), idea.getPriority(), idea.getUserId(), idea.getId());
    }

    @Override
    public void deleteIdea(int id){
        String sql = """
                DELETE FROM idea WHERE id = ?;
                """;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Idea> getIdeaById(int id){
        String sql = """
                SELECT * FROM idea WHERE id = ?
                """;
        return jdbcTemplate.query(sql, ideaRowMapper, id).stream().findFirst();
    }
}
