-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. Add yourself to the person
--     table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)

-- Step 1: Insert yourself into the person table
INSERT INTO person (person_name, birthday)
VALUES ('Aaron', '1983-02-03');

-- Step 2: Get the person_id for the newly inserted person
SELECT person_id FROM person WHERE person_name = 'Aaron';

-- Step 3: Update the director_id for "The Blob"
UPDATE movie
SET director_id = (SELECT person_id FROM person WHERE person_name = 'Aaron')
WHERE title = 'The Blob';