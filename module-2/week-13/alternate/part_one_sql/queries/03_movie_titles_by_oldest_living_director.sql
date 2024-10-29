-- 3. List the title, first and last name of the director (name the column 'director'), 
--    and release year of all movies with a living director. 
-- Order the results by the director's age, oldest first.

-- Tip: Remember to add a space between the director's first and last names.
-- Tip: A director is considered living if there isn't a 'deathdate'.
-- (42 rows)

select movie.title,
        concat(person.first_name, ' ', person.last_name) as director,
        movie.release_year
from movie
join person on movie.director_id = person.person_id
where person.deathdate is null
order by person.birthdate ASC;