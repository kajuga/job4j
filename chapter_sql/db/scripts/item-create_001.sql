-- в строку сделал, потомцу что у меня читает построчно отсюда
CREATE TABLE tracker.item (id SERIAL PRIMARY KEY NOT NULL, name VARCHAR(100), description VARCHAR(150), creation_date DATE NOT NULL);
CREATE TABLE tracker.comment (id SERIAL PRIMARY KEY NOT NULL, comment VARCHAR(250), item_id INTEGER REFERENCES tracker.item(id));
