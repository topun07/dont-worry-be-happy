-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)

SELECT m.title
from movie m
--join movie_genre mg ON mg.genre_id = g.genre_id
--join movie_actor ma ON ma.movie_id = mg.movie_id
--join person p ON p.person_id = ma.actor_id
--join movie m ON m.movie_id = ma.movie_id
join person p ON p.person_id = m.director_id
where p.person_name IN ('James Cameron')
order by m.title
;