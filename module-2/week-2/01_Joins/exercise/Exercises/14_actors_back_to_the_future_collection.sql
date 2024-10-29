-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection", sorted alphabetically.
-- (28 rows)

SELECT distinct p.person_name
from person p
join movie_actor ma ON ma.actor_id = p.person_id
join movie m ON m.movie_id = ma.movie_id
join collection c ON c.collection_id = m.collection_id
where c.collection_name IN ('Back to the Future Collection')
order by p.person_name
;