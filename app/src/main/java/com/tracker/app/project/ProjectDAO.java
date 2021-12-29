package com.tracker.app.project;

import java.util.List;

public interface ProjectDAO {

    void addProject(Project project);

    List<Project> getUserProjects(int id);

    void deleteProject(int id);
}
