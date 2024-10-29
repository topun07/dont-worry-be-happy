-- 2. The name and area of all cities in Pennsylvania (PA).
-- Order the results in reverse alphabetical order (Z-A) by city name.
-- (4 rows)

select city_name, area
from city
where state_abbreviation IN ('PA')
order by city desc;