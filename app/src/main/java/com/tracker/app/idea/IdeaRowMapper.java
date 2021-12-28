package com.tracker.app.idea;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IdeaRowMapper implements RowMapper<Idea> {

    @Override
    public Idea mapRow(ResultSet rs, int rowNum) throws SQLException {
        Idea idea = new Idea(
                rs.getInt("id"),
                rs.getString("summary"),
                rs.getString("details"),
                rs.getString("priority"),
                rs.getString("idea_references")
        );
        return idea;
    }

}
