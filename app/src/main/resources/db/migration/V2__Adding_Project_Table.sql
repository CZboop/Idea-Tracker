CREATE TABLE IF NOT EXISTS projects (id BIGSERIAL PRIMARY KEY, user_id INT REFERENCES users(id) ON delete CASCADE,
 title TEXT, details TEXT, status TEXT, priority TEXT);

