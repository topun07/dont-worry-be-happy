-- 4. List the genre name and the count (name this column 'total_movies') of the genre with the most movies. 
-- (1 row)
select genre.name, count(movie_genre.movie_id) AS total_movies
from genre
join movie_genre ON genre.genre_id = movie_genre.genre_id
group by genre.name
order by total_movies DESC
LIMIT 1;