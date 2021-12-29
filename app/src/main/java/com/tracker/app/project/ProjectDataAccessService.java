package com.tracker.app.project;

import com.tracker.app.user.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDataAccessService implements ProjectDAO{

    private JdbcTemplate jdbcTemplate;
    private ProjectRowMapper projectRowMapper;

    @Autowired
    public ProjectDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.projectRowMapper = new ProjectRowMapper();
    }

    @Override
    public void addProject(Project project){
        String sql = """
                INSERT INTO projects (user_id, title, details, status, priority) VALUES (?, ?, ?, ?, ?);
                """;
        jdbcTemplate.update(sql, project.getUserId(), project.getTitle(), project.getDetails(),
                project.getStatus().name(), project.getPriority());
    }

    @Override
    public List<Project> getUserProjects(int id){
        String sql = """
                SELECT * FROM projects WHERE user_id = ?;
                """;
        List<Project> userProjects = jdbcTemplate.query(sql, projectRowMapper, id);
        return userProjects;
    }
}
