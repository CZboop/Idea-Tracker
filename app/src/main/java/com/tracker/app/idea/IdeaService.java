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
}
