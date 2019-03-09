
CREATE TABLE rules (
  id   SERIAL PRIMARY KEY,
  NAME VARCHAR(100)
);
INSERT INTO rules VALUES (1, 'ADMIN');
INSERT INTO rules VALUES (2, 'USER');
INSERT INTO rules VALUES (3, 'READER');
INSERT INTO rules VALUES (4, 'BANNED');

CREATE TABLE roles (
  id   SERIAL PRIMARY KEY,
  rule_id INTEGER REFERENCES rules (id)
);
INSERT INTO roles VALUES (1, 1);
INSERT INTO roles VALUES (2, 2);
INSERT INTO roles VALUES (3, 3);
INSERT INTO roles VALUES (4, 4);

CREATE TABLE users (
  id      SERIAL PRIMARY KEY,
  name    VARCHAR(100),
  role_id INTEGER REFERENCES roles (id)
);
INSERT INTO users (id, name, role_id) VALUES
  (1, 'Abramovich', 1);
INSERT INTO users (id, name, role_id) VALUES
  (2, 'Fedorov', 2);
INSERT INTO users (id, name, role_id) VALUES
  (3, 'Hodorkovsky', 3);
--INSERT INTO users (id, name, role_id) VALUES
  --(4, 'Nemtsov', 4);


