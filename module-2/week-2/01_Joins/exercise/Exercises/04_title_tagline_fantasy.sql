-- 4. The titles and taglines of all the movies that are in the Fantasy genre.
-- Order the results by title (A-Z).
-- (81 rows)

SELECT m.title, m.tagline
from movie m
join movie_genre mg ON mg.movie_id = m.movie_id
join genre g ON g.genre_id = mg.genre_id
where g.genre_name IN ('Fantasy')
order by m.title;