package com.tracker.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectDAO projectDAO;

    @Autowired
    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public void addProject(Project project) {
        projectDAO.addProject(project);
    }

    public List<Project> getUserProjects(int id) {
        return projectDAO.getUserProjects(id);
    }

    public void deleteProject(int id) {
        projectDAO.deleteProject(id);
    }

    public void updateProject(int id, Project project) {
        projectDAO.updateProject(id, project);
    }
}
