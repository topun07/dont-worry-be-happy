-- 7. The population of the state with the highest population. Name the column 'largest_state_population'.
-- Expected answer is around 39,500,000
-- (1 row)

SELECT MAX(population) AS largest_state_population
FROM state
--WHERE census_region = 'South'
ORDER BY largest_state_population asc;
