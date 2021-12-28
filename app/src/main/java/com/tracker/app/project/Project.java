package com.tracker.app.project;

import com.tracker.app.ticket.Ticket;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Project {
    private String name;
    private String details;
    private ArrayList<Ticket> issues;
    private ArrayList<Ticket> toDo;

    public Project(String name, String details, ArrayList<Ticket> issues, ArrayList<Ticket> toDo) {
        this.name = name;
        this.details = details;
        this.issues = issues;
        this.toDo = toDo;
    }
}
