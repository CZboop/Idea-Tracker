CREATE TABLE IF NOT EXISTS users (id BIGSERIAL PRIMARY KEY, username TEXT,
email TEXT, password TEXT, activated BOOLEAN);

CREATE TABLE IF NOT EXISTS idea (id BIGSERIAL PRIMARY KEY, summary TEXT,
details TEXT, priority TEXT, user_id INT REFERENCES users(id) ON DELETE CASCADE);