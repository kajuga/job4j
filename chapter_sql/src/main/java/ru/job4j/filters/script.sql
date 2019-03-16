CREATE TABLE filters.type
(
  id   SERIAL NOT NULL
    CONSTRAINT type_pkey
    PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE filters.product
(
  id           SERIAL  NOT NULL
    CONSTRAINT product_pkey
    PRIMARY KEY,
  name         VARCHAR(100),
  type_id      INTEGER,
  expired_date DATE,
  price        NUMERIC NOT NULL
);

INSERT INTO filters.type (name) VALUES ('Бакалея');
INSERT INTO filters.type (name) VALUES ('Специи');
INSERT INTO filters.type (name) VALUES ('Молоко');
INSERT INTO filters.type (name) VALUES ('Сыр');
INSERT INTO filters.type (name) VALUES ('Крупа');
INSERT INTO filters.type (name) VALUES ('Колбаса');
INSERT INTO filters.type (name) VALUES ('Хлеб');
INSERT INTO filters.type (name) VALUES ('Бананы');
INSERT INTO filters.type (name) VALUES ('Картошка');

INSERT INTO filters.product (name, type_id, expired_date, price) VALUES ('Макароны', 1, '2000-07-12', 789.89);
INSERT INTO filters.product (name, type_id, expired_date, price) VALUES ('Перец горошком', 2, '2020-04-15', 22.59);
INSERT INTO filters.product (name, type_id, expired_date, price) VALUES ('Сыр Российский', 4, '2050-11-25', 500.89);
INSERT INTO filters.product (name, type_id, expired_date, price) VALUES ('Молоко Рязанское', 3, '2020-02-16', 50.65);
INSERT INTO filters.product (name, type_id, expired_date, price) VALUES ('Манка поднебесная', 5, '2020-02-22', 15.67);
INSERT INTO filters.product (name, type_id, expired_date, price) VALUES ('Сыр санкционный', 4, '2019-07-15', 1500.23);
INSERT INTO filters.product (name, type_id, expired_date, price) VALUES ('Мороженное пломбир', 1, '2020-05-05', 56.39);
INSERT INTO filters.product (name, type_id, expired_date, price) VALUES ('Молоко Волгоградское', 3, '2020-08-13', 89.47);
INSERT INTO filters.product (name, type_id, expired_date, price) VALUES ('Сыр Пармезан', 4, '2020-08-27', 1789.89);
INSERT INTO filters.product (name, type_id, expired_date, price) VALUES ('Мороженное вафельный стаканчик', 1, '2030-04-09', 16.39);

-- в задании прочитал про "количество" - добавляю столбец "количество" в posgresql как я понял, в нужное место, не пересоздавая таблицу
-- новый столбец, увы, не запихнуть:
ALTER TABLE filters.product ADD COLUMN quantity INTEGER;

UPDATE filters.product SET quantity = 17 WHERE name = 'Макароны';
UPDATE filters.product SET quantity = 32 WHERE name = 'Перец горошком';
UPDATE filters.product SET quantity = 12 WHERE name = 'Сыр Российский';
UPDATE filters.product SET quantity = 56 WHERE name = 'Молоко Рязанское';
UPDATE filters.product SET quantity = 234 WHERE name = 'Сыр санкционный';
UPDATE filters.product SET quantity = 130 WHERE name = 'Манка поднебесная';
UPDATE filters.product SET quantity = 332 WHERE name = 'Мороженное пломбир';
UPDATE filters.product SET quantity = 530 WHERE name = 'Молоко Волгоградское';
UPDATE filters.product SET quantity = 74 WHERE name = 'Сыр Пармезан';
UPDATE filters.product SET quantity = 51 WHERE name = 'Мороженное вафельный стаканчик';

-- таблица создана, заполнена, присоединяю внешний ключ из type
-- для этого мне нужно поменять тип в столбце type_id
-- employee_id     INTEGER REFERENCES employee (id)
ALTER TABLE filters.product ADD CONSTRAINT type_product FOREIGN KEY (type_id) REFERENCES filters.type (id);


-- 1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT p.name FROM filters.product as p LEFT JOIN filters.type as t ON p.type_id = t.id  WHERE t.name = 'Сыр';
-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT * FROM filters.product WHERE name LIKE '%Мороженное%';
-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT * FROM filters.product WHERE expired_date <= '2020-05-05';
-- 4. Написать запрос, который выводит самый дорогой продукт.
SELECT * FROM filters.product WHERE price = (SELECT max(price) FROM filters.product);
-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT SUM(p.quantity), t.name FROM filters.product AS p LEFT JOIN filters.type AS t ON p.type_id = t.id GROUP BY t.name;
-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT * FROM filters.product AS p LEFT JOIN filters.type AS t ON p.type_id = t.id WHERE t.name = 'Сыр' OR t.name ='Молоко';
SELECT * FROM filters.product AS p LEFT JOIN filters.type AS t ON p.type_id = t.id WHERE t.name IN ('Сыр', 'Молоко');
-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук. (У меня в таблице масштабы другие, поэтому поставил <200)
SELECT SUM(p.quantity), t.name FROM filters.product AS p LEFT JOIN filters.type AS t ON p.type_id = t.id GROUP BY t.name HAVING SUM(p.quantity) < 200;
-- 8. Вывести все продукты и их тип.
SELECT p.name, t.name FROM filters.product AS p LEFT JOIN filters.type AS t ON p.type_id = t.id;

