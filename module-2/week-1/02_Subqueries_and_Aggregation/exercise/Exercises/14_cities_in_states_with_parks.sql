-- 14. The city name and state abbreviation for all states with a national park.
-- Order the results by state abbreviation, then city name, both in alphabetical order.
-- (261 rows)

SELECT city_name, state_abbreviation
FROM city
WHERE state_abbreviation IN (
select state_abbreviation
	from park_state
	--where census_region In ('Northeast', 'Midwest')
)
ORDER BY state_abbreviation, city_name;