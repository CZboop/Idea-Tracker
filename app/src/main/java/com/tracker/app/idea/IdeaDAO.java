package com.tracker.app.idea;

import java.util.List;

public interface IdeaDAO {

    public List<Idea> getAllIdeas();

    public void addIdea(Idea idea);
}
