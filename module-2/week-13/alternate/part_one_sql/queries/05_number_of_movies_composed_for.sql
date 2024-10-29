-- 5. List the movie title, release year, and first and last name of the director (name the column 'director'), 
--    and first and last name of the composer (name the column 'composer') of all movies released in 2000 or later.
-- Order the results by the release year in descending order (highest first), then by alphabetical order by title.
-- (28 rows)

select movie.title,
        movie.release_year,
        concat (director.first_name, ' ', director.last_name) AS director,
        concat (composer.first_name, ' ', composer.last_name) AS composer
from movie
join person as director on movie.director_id = director.person_id
join person as composer on movie.music_by_id = composer.person_id
where movie.release_year >= 2000
order by movie.release_year desc, movie.title ASC;