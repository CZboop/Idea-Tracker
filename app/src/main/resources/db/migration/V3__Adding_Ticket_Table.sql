CREATE TABLE IF NOT EXISTS tickets (id BIGSERIAL PRIMARY KEY, project_id BIGINT REFERENCES projects(id) ON delete CASCADE,
 title TEXT, info TEXT, ticket_type TEXT, is_completed BOOLEAN, date_created TEXT, date_completed TEXT);
