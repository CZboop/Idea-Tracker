package com.tracker.app.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDataAccessService implements TicketDAO{

    private JdbcTemplate jdbcTemplate;
    private TicketRowMapper ticketRowMapper;

    @Autowired
    public TicketDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.ticketRowMapper = new TicketRowMapper();
    }

    @Override
    public void addTicket(Ticket ticket){
        String sql = """
                INSERT INTO tickets (project_id, title, info, ticket_type, is_completed, date_created, date_completed)
                VALUES (?, ?, ?, ?, false, ?, ?);
                """;
        jdbcTemplate.update(sql, ticket.getProjectId(), ticket.getTitle(), ticket.getInfo(), ticket.getTicketType().name(),
                ticket.getDateCreated(), ticket.getDateCompleted());
    }

    @Override
    public List<Ticket> getTicketsForProject(Long id){
        String sql = """
                SELECT * FROM tickets WHERE project_id = ?;
                """;
        List<Ticket> ticketList= jdbcTemplate.query(sql, ticketRowMapper, id);
        return ticketList;
    }

    @Override
    public void updateTicket(Ticket ticket, int id){
        String sql = """
                UPDATE tickets SET title = ?, info = ?, ticket_type = ?, is_completed = ?
                WHERE id = ?;
                """;
        jdbcTemplate.update(sql, ticket.getTitle(), ticket.getInfo(),
                ticket.getTicketType().name(), ticket.getIsCompleted(), id);
    }

    @Override
    public void deleteTicket(int id){
        String sql = """
                DELETE FROM tickets WHERE id = ?;
                """;
        jdbcTemplate.update(sql, id);
    }
}
