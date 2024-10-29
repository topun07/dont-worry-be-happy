-- 17. The highest population density of all records in the state table. Name the column 'population_density'.
-- Population density is expressed as people per square kilometer. In other words, population divided by area.
-- Exepcted answer is around 4,000
-- (1 row)

SELECT MAX (population / area) AS population_density
FROM state
--WHERE state_abbreviation IN (
--select state_abbreviation
--	from park_state
	--where census_region In ('Northeast', 'Midwest')

--ORDER BY state_abbreviation, city_name;