ALTER TABLE idea DROP COLUMN IF EXISTS idea_references;
ALTER TABLE idea ADD user_id INT;