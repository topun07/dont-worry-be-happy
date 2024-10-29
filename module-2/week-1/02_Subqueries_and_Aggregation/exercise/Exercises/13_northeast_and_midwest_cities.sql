-- 13. The city name, state abbreviation, and population for all cities in the Northeast and Midwest census regions.
-- Order the results by state abbreviation first (alphabetical), then by population (largest first).
-- (84 rows)

SELECT city_name, state_abbreviation, population
FROM city
WHERE state_abbreviation IN (
select state_abbreviation
	from state
	where census_region In ('Northeast', 'Midwest')
)
ORDER BY state_abbreviation, population desc;