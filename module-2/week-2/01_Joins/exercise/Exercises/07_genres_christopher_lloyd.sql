-- 7. The genres of movies that Christopher Lloyd has appeared in, sorted alphabetically.
-- (8 rows) Hint: DISTINCT will prevent duplicate values in your query results.

SELECT distinct g.genre_name
from genre g
join movie_genre mg ON mg.genre_id = g.genre_id
join movie_actor ma ON ma.movie_id = mg.movie_id
join person p ON p.person_id = ma.actor_id
where p.person_name IN ('Christopher Lloyd')
order by g.genre_name
;

