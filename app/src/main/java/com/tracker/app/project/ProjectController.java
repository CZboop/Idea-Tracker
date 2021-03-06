package com.tracker.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public void addProject(@RequestBody Project project){
        projectService.addProject(project);
    }

    @GetMapping("/userid/{id}")
    public List<Project> getUserProjects(@PathVariable int id){
        return projectService.getUserProjects(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable int id){
        projectService.deleteProject(id);
    }

    @PutMapping("/update/{id}")
    public void updateProject(@PathVariable int id, @RequestBody Project project){
        projectService.updateProject(id, project);
    }
}
