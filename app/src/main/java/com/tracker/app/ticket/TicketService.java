package com.tracker.app.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private TicketDAO ticketDAO;

    @Autowired
    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public void addTicket(Ticket ticket) {
        ticketDAO.addTicket(ticket);
    }

    public List<Ticket> getTicketsForProject(int id) {
        return ticketDAO.getTicketsForProject(id);
    }

    public void updateTicket(Ticket ticket, int id) {
        ticketDAO.updateTicket(ticket, id);
    }

    public void deleteTicket(int id) {
        ticketDAO.deleteTicket(id);
    }
}
