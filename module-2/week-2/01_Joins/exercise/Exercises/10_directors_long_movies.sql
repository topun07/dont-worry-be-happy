-- 10. The names of directors who have directed a movie over 3 hours [180 minutes], sorted alphabetically.
-- (15 rows)

SELECT distinct p.person_name
from person p
--join movie_genre mg ON mg.genre_id = g.genre_id
--join movie_actor ma ON ma.movie_id = mg.movie_id
--join person p ON p.person_id = ma.actor_id
--join movie m ON m.movie_id = ma.movie_id
--join person p ON p.person_id = m.director_id
join movie m ON p.person_id = m.director_id
where m.length_minutes > 180
order by p.person_name
;