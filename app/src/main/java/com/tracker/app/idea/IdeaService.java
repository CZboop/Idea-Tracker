package com.tracker.app.idea;

import org.springframework.stereotype.Service;

@Service
public class IdeaService {

    private IdeaDAO ideaDAO;

    public IdeaService(IdeaDAO ideaDAO) {
        this.ideaDAO = ideaDAO;
    }
}
