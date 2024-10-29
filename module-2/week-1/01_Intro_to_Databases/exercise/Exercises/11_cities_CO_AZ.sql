-- 11. The name, state, and population of all cities in Colorado (CO) or Arizona (AZ).
-- Order the results by state abbreviation alphabetically (A-Z), then by populatuon (highest first).
-- (22 rows)

select city_name, state_abbreviation, population
From city
where state_abbreviation IN ('CO')  OR state_abbreviation IN ('AZ')
order by state_abbreviation, population desc;