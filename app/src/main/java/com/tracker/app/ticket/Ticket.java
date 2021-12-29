package com.tracker.app.ticket;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Ticket {

    private Long id;
    private Long projectId;
    private String title;
    private String info;
    private Type ticketType;
    private Boolean isCompleted;
    private String dateCreated;

    public Ticket(Long id, Long projectId, String title, String info, Type ticketType,
                  Boolean isCompleted, String dateCreated) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.info = info;
        this.ticketType = ticketType;
        this.isCompleted = isCompleted;
        this.dateCreated = dateCreated;
    }
}
