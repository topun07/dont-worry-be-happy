-- 1. The titles and release dates of movies that Tom Hanks has appeared in.
-- Order the results by release date, newest to oldest.
-- (47 rows)

SELECT m.title, m.release_date -- m is an alias for movie
FROM movie m
JOIN movie_actor ma ON m.movie_id = ma.movie_id -- joining movie_id's of movie_actor and movie
JOIN person p ON ma.actor_id = p.person_id -- joining actor_id's of person and movie
WHERE p.person_name = 'Tom Hanks' -- identifying Tom as the base of the data
order by release_date desc;