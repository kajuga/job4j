-- create tables
CREATE TABLE IF NOT EXISTS tracker.company (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(100));
CREATE TABLE IF NOT EXISTS tracker.person (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(100), company_id INTEGER REFERENCES tracker.company(id));

