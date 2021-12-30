package com.tracker.app.idea;

import com.tracker.app.project.Project;
import com.tracker.app.project.ProjectService;
import com.tracker.app.project.Status;
import com.tracker.app.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaService {

    private IdeaDAO ideaDAO;
    private UserService userService;
    private ProjectService projectService;

    public IdeaService(IdeaDAO ideaDAO, UserService userService, ProjectService projectService) {
        this.ideaDAO = ideaDAO;
        this.userService = userService;
        this.projectService = projectService;
    }

    public List<Idea> getAllIdeas() {
        return ideaDAO.getAllIdeas();
    }

    public void addIdea(Idea idea) {
        boolean userIsValid = userService.userExistsById(idea.getUserId());
        if (!userIsValid){
            throw new IllegalStateException("User not found");
        }
        ideaDAO.addIdea(idea);
    }

    public void updateIdea(Idea idea) {
        ideaDAO.updateIdea(idea);
    }

    public void deleteIdea(int id) {
        ideaDAO.deleteIdea(id);
    }

    public void makeProjectFromIdeaId(int id) {
        Idea idea = getIdeaById(id);
        Project projectFromIdea = new Project(
                null,
                    Long.valueOf(idea.getUserId()),
                    idea.getSummary(),
                    idea.getDetails(),
                    Status.ACTIVE,
                    idea.getPriority(),
                    null
        );
        projectService.addProject(projectFromIdea);
        ideaDAO.deleteIdea(id);
    }

    public Idea getIdeaById(int id) {
        return ideaDAO.getIdeaById(id).orElseThrow(IllegalStateException::new);
    }
}
