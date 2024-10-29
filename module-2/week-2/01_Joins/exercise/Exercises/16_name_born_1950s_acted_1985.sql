-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)

SELECT distinct p.person_name, p.birthday
from person p
join movie_actor ma ON ma.actor_id = p.person_id
join movie m ON ma.movie_id = m.movie_id
where p.birthday between '1950-01-01' AND '1959-12-31' AND m.release_date between '1985-1-01' AND '1985-12-31'
order by p.birthday
;