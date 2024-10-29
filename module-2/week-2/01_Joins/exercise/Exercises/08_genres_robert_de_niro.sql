-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later, sorted alphabetically.
-- (6 rows)

SELECT distinct g.genre_name
from genre g
join movie_genre mg ON mg.genre_id = g.genre_id
join movie_actor ma ON ma.movie_id = mg.movie_id
join person p ON p.person_id = ma.actor_id
join movie m ON m.movie_id = ma.movie_id
where p.person_name IN ('Robert De Niro')
    AND  m.release_date >= '2010-01-01'
order by g.genre_name
;