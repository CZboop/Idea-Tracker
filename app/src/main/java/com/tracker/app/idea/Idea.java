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
    private String summary;
    private String details;
    private String priority;
    private String references;

    public Idea(String summary, String details, String priority, String references) {
        this.summary = summary;
        this.details = details;
        this.priority = priority;
        this.references = references;
    }
}
