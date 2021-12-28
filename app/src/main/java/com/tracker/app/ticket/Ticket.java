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
    private String title;
    private String info;
    private String type;
    private Boolean isCompleted;
    private String dateCreated;

    public Ticket(String title, String info, String type, Boolean isCompleted, String dateCreated) {
        this.title = title;
        this.info = info;
        this.type = type;
        this.isCompleted = isCompleted;
        this.dateCreated = dateCreated;
    }
}
