-- 14. The state name, nickname, and census region for states that start with the word "New".
-- Order the results by census region alphabetically, then state nickname alphabetically.
-- (4 rows)

select state_name, state_nickname, census_region
From state
where state_name  LIKE 'New%'
order by census_region, state_nickname;