-- 8. The name and population of cities in California (CA) with a population less than 150,000 people.
-- Order the results by population, smallest first.
-- (37 rows)

select city_name, population
From city
where population <= 150000 AND state_abbreviation IN ('CA')
order by population;