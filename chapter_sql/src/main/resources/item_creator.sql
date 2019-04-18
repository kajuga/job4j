
CREATE TABLE tracker.name (
  id SERIAL PRIMARY KEY NOT NULL ,
  name VARCHAR(150) NOT NULL
);
INSERT INTO tracker.name VALUES (1, 'Incoming mail');
INSERT INTO tracker.name VALUES (2, 'Outcoming mail');
INSERT INTO tracker.name VALUES (3, 'Internal correspondence');
INSERT INTO tracker.name VALUES (4, 'Service note');

CREATE TABLE tracker.description (
  id SERIAL PRIMARY KEY NOT NULL ,
  description VARCHAR(200)
);
INSERT INTO tracker.description (id, description) VALUES (1, 'description_text_first');
INSERT INTO tracker.description (id, description) VALUES (2, 'description_text_second');
INSERT INTO tracker.description (id, description) VALUES (3, 'description_text_third');
INSERT INTO tracker.description (id, description) VALUES (4, 'description_text_fourth');
INSERT INTO tracker.description (id, description) VALUES (5, 'description_text_fifth');

CREATE TABLE tracker.comment (
  id SERIAL PRIMARY KEY NOT NULL ,
  comment VARCHAR(250)
);
INSERT INTO tracker.comment (id, comment) VALUES (1, 'commit_text_first');
INSERT INTO tracker.comment (id, comment) VALUES (2, 'commit_text_second');
INSERT INTO tracker.comment (id, comment) VALUES (3, 'commit_text_third');
INSERT INTO tracker.comment (id, comment) VALUES (4, 'commit_text_fourth');
INSERT INTO tracker.comment (id, comment) VALUES (5, 'commit_text_fifth');

CREATE TABLE tracker.item (
  id SERIAL PRIMARY KEY NOT NULL,
  name INTEGER REFERENCES tracker.name (id),
  description INTEGER REFERENCES tracker.description (id),
  comments INTEGER REFERENCES  tracker.comment (id),
  creation_date DATE NOT NULL
);
INSERT INTO tracker.item  (id, name, description, comments, creation_date) VALUES (DEFAULT, 1, 3, 1, NOW());
INSERT INTO tracker.item  (id, name, description, comments, creation_date) VALUES (DEFAULT, 2, 1, 3, NOW());
INSERT INTO tracker.item  (id, name, description, comments, creation_date) VALUES (DEFAULT, 4, 2, 2, NOW());
INSERT INTO tracker.item  (id, name, description, comments, creation_date) VALUES (DEFAULT, 3, 3, 2, NOW());
INSERT INTO tracker.item  (id, name, description, comments, creation_date) VALUES (DEFAULT, 1, 5, 5, NOW());
INSERT INTO tracker.item  (id, name, description, comments, creation_date) VALUES (DEFAULT, 3, 4, 4, NOW());