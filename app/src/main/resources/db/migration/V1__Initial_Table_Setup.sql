CREATE TABLE IF NOT EXISTS idea (id BIGSERIAL PRIMARY KEY, summary TEXT,
details TEXT, priority TEXT, user_id INT);