
CREATE TABLE abap_testing.familyBonds (
  people_id SERIAL PRIMARY KEY,
  gender CHAR (3) NOT NULL ,
  full_name VARCHAR(50) NOT NULL,
  age INTEGER NOT NULL ,
  father INTEGER,
  mother INTEGER,
  spouse INTEGER,
  FOREIGN KEY (father) REFERENCES abap_testing.familyBonds (people_id),
  FOREIGN KEY (mother) REFERENCES abap_testing.familyBonds (people_id),
  FOREIGN KEY (spouse) REFERENCES abap_testing.familyBonds (people_id));

INSERT INTO abap_testing.familyBonds (gender, full_name, age, father, mother, spouse)
VALUES
('M', 'Иванов Иван Иванович', '33',  NULL,  NULL ,2),
('F', 'Иванова Татьяна Сергеевна', 29 ,NULL, NULL, 1) ,
('M', 'Иванов Сергей Иванович', 1, 1, 2, NULL),
('M', 'Иванов Петр Иванович', 3, 1, 2, NULL),
('F', 'Иванова Мария Ивановна', 5, 1, 2, NULL),
('F', 'Петрова Анастасия Валерьевна', 46, NULL, NULL, NULL),
('M', 'Сидоров Антон Семенович', 49, NULL, NULL, NULL),
('F', 'Петрова Екатерина Антоновна', 15, 7, 6, NULL),
('M', 'Петров Кирилл Антонович', 17, 7, 6, NULL),
('M', 'Никифоров Тимур Андреевич', 35, NULL, NULL, NULL),
('F', 'Никифорова Дарья Тимуровна', 5, 10, NULL, NULL),
('M', 'Семенов Константин Игоревич', 42, NULL, NULL, 13),
('F', 'Семенова Татьяна Сергеевна', 43, NULL, NULL, 12),
('M', 'Семенов Марат Константинович', 13, 12, 13, NULL),
('M', 'Семенов Артур Константинович', 16, 12, 13, NULL);

-- необходимо составить запросы, который вернут:
-- a) Отца наибольшего количества детей
SELECT COUNT(d.people_id) AS count_baby, f.full_name AS father
FROM abap_testing.familyBonds AS d
  INNER JOIN abap_testing.familyBonds AS f ON d.father = f.people_id
GROUP BY f.people_id
HAVING COUNT(d.people_id) = (SELECT MAX(i.count_baby)
                             FROM (
                               SELECT COUNT(d.people_id) AS count_baby, f.full_name AS father
                               FROM abap_testing.familyBonds AS d
                                 INNER JOIN abap_testing.familyBonds AS f ON d.father = f.people_id
                               GROUP BY f.people_id
                             ) as i);


-- b) Семьи, в которых 3 и более ребенка
select count(d.people_id) as child_count, m.full_name as mother, f.full_name as father
from abap_testing.familybonds as d
  left join abap_testing.familybonds as m on d.mother = m.people_id
  left join abap_testing.familybonds as f on d.father = f.people_id
where
  (d.father is not null and d.mother is not null)
  or
  (d.father is null and d.mother is not null)
  or
  (d.father is not null and d.mother is null)
group by m.people_id, f.people_id
having count(d.people_id) >= 3;

-- c) Мать с наименьшей разницей в возрасте с собственным ребенком
select m.full_name as mother
from abap_testing.familybonds as d
  inner join abap_testing.familybonds as m on d.mother = m.people_id
where m.age - d.age in (select max(m.age - d.age)
                        from abap_testing.familybonds as d
                          inner join abap_testing.familybonds as m on d.mother = m.people_id);

-- d) Всех детей из неполных семей
SELECT d.full_name AS no_any_parent_babies
FROM abap_testing.familybonds as d
WHERE  (d.father IS NULL AND d.mother IS NOT NULL)
       OR
       (d.father IS NOT NULL AND d.mother IS NULL);