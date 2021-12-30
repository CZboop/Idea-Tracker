package com.tracker.app.idea;

import com.tracker.app.exception.ResourceNotFound;
import com.tracker.app.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaService {

    private IdeaDAO ideaDAO;
    private UserService userService;

    public IdeaService(IdeaDAO ideaDAO, UserService userService) {
        this.ideaDAO = ideaDAO;
        this.userService = userService;
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
//        steps - get idea object from db
//        - make project object from idea object
//        - add project to database
//        - delete idea from ideas db?
    }

    public Idea getIdeaById(int id) {
        return ideaDAO.getIdeaById(id).orElseThrow(IllegalStateException::new);
    }
}
