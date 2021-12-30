package com.tracker.app.idea;

import java.util.List;
import java.util.Optional;

public interface IdeaDAO {

    public List<Idea> getAllIdeas();

    public void addIdea(Idea idea);

    public void updateIdea(Idea idea);

    public void deleteIdea(int id);

    Optional<Idea> getIdeaById(int id);
}
