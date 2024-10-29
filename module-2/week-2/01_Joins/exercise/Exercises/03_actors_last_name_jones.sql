-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in.
-- Order the results by the actor names (A-Z) and then by movie title (A-Z).
-- (48 rows)

SELECT p.person_name, m.title
FROM person p
join movie_actor ma ON ma.actor_id = p.person_id
join movie m ON m.movie_id = ma.movie_id
where p.person_name like ('% Jones')
order by p.person_name, m.title;
