-- 6. The genres of "The Wizard of Oz" sorted in alphabetical order (A-Z).
-- (3 rows)
SELECT g.genre_name
from genre g
join movie_genre mg ON mg.genre_id = g.genre_id
join movie m ON m.movie_id = mg.movie_id
where m.title IN ('The Wizard of Oz')
order by g.genre_name
;

