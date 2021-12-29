package com.tracker.app.ticket;


import com.tracker.app.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ticket")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/add")
    public void addTicket(@RequestBody Ticket ticket){
        ticketService.addTicket(ticket);
    }

    @GetMapping("/getproject/{id}")
    public List<Ticket> getTicketsForProject(@PathVariable int id){
        return ticketService.getTicketsForProject(id);
    }
}
