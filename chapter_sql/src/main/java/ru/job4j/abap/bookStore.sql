-- Задача: Используя схему БД книжного магазина с таблицами Genre – жанр
-- литературы, Book - книги, составить запрос для поиска количества и общей
-- стоимости книг каждого жанра (в определенный момент времени в магазине
-- может не быть книг конкретного жанра):


CREATE TABLE abap_testing.genre (
  genre_ID SERIAL NOT NULL PRIMARY KEY,
  genre_name VARCHAR(50)
);

CREATE TABLE abap_testing.book (
  book_id SERIAL PRIMARY KEY,
  genre_id INTEGER REFERENCES abap_testing.genre(genre_ID),
  quantity INTEGER,
  price MONEY
);

INSERT INTO  abap_testing.genre (genre_ID, genre_name) VALUES (1, 'Classic');
INSERT INTO  abap_testing.genre (genre_ID, genre_name) VALUES (2, 'Fantasy');
INSERT INTO  abap_testing.genre (genre_ID, genre_name) VALUES (3, 'Sci-fi');
INSERT INTO  abap_testing.genre (genre_ID, genre_name) VALUES (4, 'Pulp fiction');
INSERT INTO  abap_testing.genre (genre_ID, genre_name) VALUES (5, 'Comics');
INSERT INTO  abap_testing.genre (genre_ID, genre_name) VALUES (6, 'Poetry');

INSERT INTO abap_testing.book (book_id, genre_id, quantity, price) VALUES (1, 2, 13, 15.01);
INSERT INTO abap_testing.book (book_id, genre_id, quantity, price) VALUES (2, 5, 25, 12.23);
INSERT INTO abap_testing.book (book_id, genre_id, quantity, price) VALUES (3, 4, 2, 09.15);
INSERT INTO abap_testing.book (book_id, genre_id, quantity, price) VALUES (4, 3, 11, 55.88);
INSERT INTO abap_testing.book (book_id, genre_id, quantity, price) VALUES (5, 5, 7, 16.78);
INSERT INTO abap_testing.book (book_id, genre_id, quantity, price) VALUES (6, 2, 3, 110.95);
INSERT INTO abap_testing.book (book_id, genre_id, quantity, price) VALUES (7, 4, 14, 67.05);
INSERT INTO abap_testing.book (book_id, genre_id, quantity, price) VALUES (8, 1, 1, 73.22);
INSERT INTO abap_testing.book (book_id, genre_id, quantity, price) VALUES (9, 6, 0, 73.22);
UPDATE abap_testing.book SET price = 0 WHERE book_id = 9;

-- составить запрос для поиска количества и общей стоимости книг каждого жанра
SELECT g.genre_name, SUM(b.quantity), SUM(b.price)
FROM abap_testing.genre AS g LEFT JOIN abap_testing.book AS b
    ON b.genre_id = g.genre_ID GROUP BY g.genre_name;

