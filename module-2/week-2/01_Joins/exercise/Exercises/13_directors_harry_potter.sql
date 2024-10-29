-- 13. The directors of the movies in the "Harry Potter Collection", sorted alphabetically.
-- (4 rows)

SELECT distinct p.person_name
from person p
--join movie_genre mg ON mg.genre_id = g.genre_id
--join movie_actor ma ON ma.movie_id = mg.movie_id
--join person p ON p.person_id = ma.actor_id
--join movie m ON m.movie_id = ma.movie_id
--join person p ON p.person_id = m.director_id
join movie m ON p.person_id = m.director_id
join collection c ON c.collection_id = m.collection_id
where c.collection_name IN ('Harry Potter Collection')AND p.person_name != ('George Lucas')
order by p.person_name
;