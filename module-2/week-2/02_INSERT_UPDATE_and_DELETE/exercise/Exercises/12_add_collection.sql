-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set
--     their collection ID to the "Bill Murray Collection". (1 row, 6 rows)

-- Step 1: Insert the new collection into the collection table
INSERT INTO collection (collection_name)
VALUES ('Bill Murray Collection');

-- Step 2: Get the person_id for Bill Murray
SELECT person_id FROM person WHERE person_name = 'Bill Murray';

-- Assume the person_id returned is 101 for this example

-- Step 3: Get the collection_id for the newly inserted "Bill Murray Collection"
SELECT collection_id FROM collection WHERE collection_name = 'Bill Murray Collection';

-- Assume the collection_id returned is 202 for this example

-- Step 4: Update the collection_id for the movies that have Bill Murray in them
UPDATE movie
SET collection_id = (SELECT collection_id FROM collection WHERE collection_name = 'Bill Murray Collection')
WHERE movie_id IN (
    SELECT movie_id
    FROM movie_actor
    WHERE actor_id = (SELECT person_id FROM person WHERE person_name = 'Bill Murray')
);
