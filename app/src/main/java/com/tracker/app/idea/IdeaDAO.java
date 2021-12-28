package com.tracker.app.idea;

import java.util.List;

public interface IdeaDAO {

    public List<Idea> getAllIdeas();

    public void addIdea(Idea idea);

    public void updateIdea(Idea idea);

    public void deleteIdea(int id);
}
