-- 2. Select the filming_country and their average movie length (name this column 'avg_length_minutes') for all movies.
-- Order the results by the average movie length, highest first.
-- (20 rows, starting with 'Canada')

select filming_country, avg(length_minutes) AS avg_length_minutes
from movie
group by filming_country
order by avg_length_minutes desc;
