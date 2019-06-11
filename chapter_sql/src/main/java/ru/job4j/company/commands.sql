-- 1) Retrieve in a single query:
-- - names of all persons that are NOT in the company with id = 5
-- - company name for each person
SELECT p.name, c.name
FROM tracker.person as p
  left join tracker.company as c
    on p.company_id = c.id
where p.company_id <> 5;

-- 2) Select the name of the company with the maximum number of persons + number of persons in this company
SELECT
  c.name,
  count(c.id) AS count
FROM tracker.company AS c
  JOIN tracker.person AS p ON c.id = p.company_id
GROUP BY c.name
ORDER BY count
DESC
LIMIT 1


