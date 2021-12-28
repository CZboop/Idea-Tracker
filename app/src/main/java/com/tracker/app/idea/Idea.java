package com.tracker.app.idea;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Idea {
    private int id;
    private String summary;
    private String details;
    private String priority;
    private String ideaReferences;
    private int userId;

    public Idea(int id, String summary, String details, String priority, String ideaReferences, int userId) {
        this.id = id;
        this.summary = summary;
        this.details = details;
        this.priority = priority;
        this.ideaReferences = ideaReferences;
        this.userId = userId;
    }
}
