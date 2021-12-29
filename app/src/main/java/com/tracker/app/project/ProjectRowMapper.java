package com.tracker.app.project;

import com.tracker.app.user.User;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        Project project = new Project(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("details"),
                Status.valueOf(rs.getString("status")),
                rs.getString("priority"),
                null
        );
        return project;
    }
}
