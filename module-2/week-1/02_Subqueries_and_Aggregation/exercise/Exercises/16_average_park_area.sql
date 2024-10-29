-- 16. The average area of national parks that have camping. Name the column 'average_park_area'.
-- Expected answer is around 3,900.
-- (1 row)
select AVG(area) AS average_park_area
from park
where has_camping = true
--select park_id
--from park_state
--where state_abbreviation IN ('MT', 'WY'))
--order by park_name
;


