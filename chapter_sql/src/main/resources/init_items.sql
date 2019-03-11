CREATE DATABASE sashok_database;
--drop DATABASE sashok_database;
--CREATE USER sashok WITH password '111';
--CREATE DATABASE sashok_database OWNER sashok;
--GRANT ALL PRIVILEGES ON DATABASE sashok_database TO sashok;

CREATE TABLE rule (
  id   SERIAL PRIMARY KEY,
  NAME VARCHAR(100)
);
INSERT INTO rule VALUES (1, 'READ');
INSERT INTO rule VALUES (2, 'WRITE');
INSERT INTO rule VALUES (3, 'EDIT');
INSERT INTO rule VALUES (4, 'CREATE');
INSERT INTO rule VALUES (5, 'DELETE');

CREATE TABLE role (
  id      SERIAL PRIMARY KEY,
  name    VARCHAR
);

INSERT INTO role VALUES (1, 'admin');
INSERT INTO role VALUES (2, 'user');
INSERT INTO role VALUES (3, 'guest');

CREATE TABLE role_rule (
  role_id INTEGER REFERENCES role (id),
  rule_id INTEGER REFERENCES rule (id)
);

INSERT INTO role_rule VALUES (1, 1);
INSERT INTO role_rule VALUES (1, 2);
INSERT INTO role_rule VALUES (1, 3);
INSERT INTO role_rule VALUES (1, 4);
INSERT INTO role_rule VALUES (1, 5);

INSERT INTO role_rule VALUES (2, 1);
INSERT INTO role_rule VALUES (2, 2);
INSERT INTO role_rule VALUES (2, 3);
INSERT INTO role_rule VALUES (2, 4);

INSERT INTO role_rule VALUES (3, 1);


CREATE TABLE user (
  id      SERIAL PRIMARY KEY,
  name    VARCHAR(100),
  role_id INTEGER REFERENCES roles (id)
);
INSERT INTO user (id, name, role_id) VALUES (1, 'Abramovich', 1);
INSERT INTO user (id, name, role_id) VALUES (2, 'Fedorov', 2);
INSERT INTO user (id, name, role_id) VALUES (3, 'Hodorkovsky', 3);
INSERT INTO user (id, name, role_id) VALUES (4, 'Nemtsov', 3);

CREATE TABLE category (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(100)
);
INSERT INTO category (id, name) VALUES (1, 'DIRECTORATE');
INSERT INTO category (id, name) VALUES (2, 'ACCOUNTING');
INSERT INTO category (id, name) VALUES (3, 'SECURITY');

CREATE TABLE status (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(100)
);
INSERT INTO status (id, name) VALUES (1, 'SENT');
INSERT INTO status (id, name) VALUES (2, 'RECEIVED');
INSERT INTO status (id, name) VALUES (3, 'READ');
INSERT INTO status (id, name) VALUES (4, 'FINISHED');
INSERT INTO status (id, name) VALUES (5, 'REJECTED');

CREATE TABLE attach (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(100)
);
INSERT INTO attach (name) VALUES ('C:\\1.txt');
INSERT INTO attach (name) VALUES ('C:\\2.jpg');
INSERT INTO attach (name) VALUES ('C:\\3.doc');



CREATE TABLE comment (
  id           SERIAL PRIMARY KEY,
  text_comment VARCHAR(200)
);
INSERT INTO comment (id, text_comment) VALUES (1, 'commit_text_first');
INSERT INTO comment (id, text_comment) VALUES (2, 'commit_text_second');
INSERT INTO comment (id, text_comment) VALUES (3, 'commit_text_third');

CREATE TABLE item (
  id          SERIAL PRIMARY KEY,
  user_id     INTEGER REFERENCES user (id),
  status_id   INTEGER REFERENCES status (id),
  category_id INTEGER REFERENCES category (id)
);

INSERT INTO item VALUES (1, 1, 1, 1);

CREATE TABLE item_comment (
  item_id     INTEGER REFERENCES item (id),
  comment_id  INTEGER REFERENCES comment (id)
);

INSERT INTO item_comment VALUES (1, 1);
INSERT INTO item_comment VALUES (1, 2);
-- аналогично с аттач
CREATE TABLE item_attach (
  item_id     INTEGER REFERENCES item (id),
  attach_id  INTEGER REFERENCES attach (id)
);


--   private User user;
-- private List<Comment> comments;
-- private List<Attach> attaches;
-- private List<Status> status;
-- private Category category;