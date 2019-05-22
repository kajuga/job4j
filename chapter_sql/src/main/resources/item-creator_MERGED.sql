-- в строку сделал, потомцу что у меня читает построчно отсюда
CREATE TABLE tracker.item (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(100), description VARCHAR(150), creation_date DATE NOT NULL);
INSERT INTO tracker.item VALUES (1, 'Incoming mail', 'description_text_fifth', NOW());
INSERT INTO tracker.item VALUES (2, 'Incoming mail', 'description_text_fourth', NOW());
INSERT INTO tracker.item VALUES (3, 'Incoming mail', 'description_text_second', NOW());
INSERT INTO tracker.item VALUES (4, 'Incoming mail', 'description_text_third', NOW());
INSERT INTO tracker.item VALUES (5, 'Incoming mail', 'description_text_first', NOW());
INSERT INTO tracker.item VALUES (6, 'Incoming mail', 'description_text_fourth', NOW());
CREATE TABLE tracker.comment (id SERIAL PRIMARY KEY NOT NULL, comment VARCHAR(250), item_id INTEGER REFERENCES tracker.item(id));
INSERT INTO tracker.comment (id, comment, item_id) VALUES (1, 'commit_text_first', 3);
INSERT INTO tracker.comment (id, comment, item_id) VALUES (2, 'commit_text_second', 2);
INSERT INTO tracker.comment (id, comment, item_id) VALUES (3, 'commit_text_third', 4);
INSERT INTO tracker.comment (id, comment, item_id) VALUES (4, 'commit_text_fourth', 1);
INSERT INTO tracker.comment (id, comment, item_id) VALUES (5, 'commit_text_fifth', 6);