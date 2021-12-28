package com.tracker.app.idea;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaService {

    private IdeaDAO ideaDAO;

    public IdeaService(IdeaDAO ideaDAO) {
        this.ideaDAO = ideaDAO;
    }

    public List<Idea> getAllIdeas() {
        return ideaDAO.getAllIdeas();
    }

    public void addIdea(Idea idea) {
        ideaDAO.addIdea(idea);
    }

    public void updateIdea(Idea idea) {
        ideaDAO.updateIdea(idea);
    }

    public void deleteIdea(int id) {
        ideaDAO.deleteIdea(id);
    }
}
