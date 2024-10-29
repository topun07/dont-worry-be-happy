-- 1. The name and population of all cities in Ohio (OH).
-- Order the results alphabetically (A-Z) by city.
-- (6 rows)
select city_name, population
from city
where state_abbreviation IN ('OH')
order by city;
