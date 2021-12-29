package com.tracker.app.ticket;

import com.tracker.app.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketRowMapper implements RowMapper<Ticket> {

    @Override
    public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {

        Ticket ticket = new Ticket(
                rs.getLong("id"),
                rs.getLong("project_id"),
                rs.getString("title"),
                rs.getString("info"),
                Type.valueOf(rs.getString("ticket_type")),
                rs.getBoolean("is_completed"),
                rs.getString("date_created"),
                rs.getString("date_completed")
        );
        return ticket;
    }
}
