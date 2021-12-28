CREATE TABLE IF NOT EXISTS users (id BIGSERIAL PRIMARY KEY, username TEXT,
email TEXT, password TEXT, activated BOOLEAN);