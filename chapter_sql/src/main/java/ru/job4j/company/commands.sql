SELECT pers.name AS NAME, comp.name AS COMPANY_NAME
FROM tracker.person AS pers LEFT JOIN tracker.company AS comp ON pers WHERE company_id = 5;

SELECT p.name, c.name
FROM tracker.person as p
  left join tracker.company as c
    on p.company_id = c.id
where p.company_id <> 5;