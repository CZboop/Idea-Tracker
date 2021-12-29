package com.tracker.app.ticket;

import java.util.List;

public interface TicketDAO {

    void addTicket(Ticket ticket);

    List<Ticket> getTicketsForProject(int id);
}
