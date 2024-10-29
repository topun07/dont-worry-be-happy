-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)

SELECT distinct m.title, p.person_name
from movie m
join person p ON p.person_id = m.director_id
--join movie m ON m.movie_id = ma.movie_id
--join movie_actor ma ON p.person_id = ma.actor_id
join movie_actor ma ON m.movie_id = ma.movie_id
--join collection c ON c.collection_id = m.collection_id
where p.person_id = ma.actor_id
order by m.title
;