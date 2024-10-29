-- 1. List the title and release year of all the movies with the Action genre. 
-- Order the results by release year, earliest first.
-- (5 rows)
select movie.title, movie.release_year
from movie
join movie_genre ON movie.movie_id = movie_genre.movie_id
join genre ON movie_genre.genre_id = genre.genre_id
where genre.name = 'Action'
order by movie.release_year ASC;