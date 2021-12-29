package com.tracker.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private ProjectDAO projectDAO;

    @Autowired
    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }
}
