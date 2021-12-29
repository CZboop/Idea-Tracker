package com.tracker.app.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDataAccessService implements TicketDAO{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TicketDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addTicket(Ticket ticket){
        String sql = """
                INSERT INTO tickets (project_id, title, info, ticket_type, is_completed, date_created, date_completed)
                VALUES (?, ?, ?, ?, false, ?, ?);
                """;
        jdbcTemplate.update(sql, ticket.getProjectId(), ticket.getTitle(), ticket.getInfo(), ticket.getTicketType().name(),
                ticket.getDateCreated(), ticket.getDateCompleted());
    }
}
