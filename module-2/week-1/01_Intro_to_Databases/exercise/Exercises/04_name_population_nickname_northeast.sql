-- 4. The name, population, and nickname of the states in the "Northeast" census region.
-- Order the results by population, highest first.
-- (9 rows)

select state_name, population, state_nickname
From state
where census_region IN ('Northeast')
order by population desc;