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
    private Long id;
    private Long userId;
    private String name;
    private String details;
    private Status status;
    private String priority;
    private ArrayList<Ticket> tickets;

    public Project(Long id, Long userId, String name, String details, Status status,
                   String priority, ArrayList<Ticket> tickets) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.details = details;
        this.status = status;
        this.priority = priority;
        this.tickets = tickets;
    }
}
