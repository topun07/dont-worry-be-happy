-- 5. The titles and release dates of all the movies that are in the Comedy genre.
-- Order the results by release date, earliest to latest.
-- (220 rows)

SELECT m.title, m.release_date
from movie m
join movie_genre mg ON mg.movie_id = m.movie_id
join genre g ON g.genre_id = mg.genre_id
where g.genre_name IN ('Comedy')
order by m.release_date
;
