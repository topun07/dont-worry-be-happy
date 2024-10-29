

--####################################################################################
--####################################################################################
-- SELECT
-- Use a SELECT statement to return a literal string

SELECT 'Hello SQL!';

-- Use a SELECT statement to add two numbers together (and label the result "sum")

SELECT 2 + 2 AS sum;


--####################################################################################
--####################################################################################
-- SELECT ... FROM
-- Write queries to retrieve...

-- The names from all the records in the state table

SELECT state_name
FROM state;

-- The names and populations of all cities

SELECT city_name, population
FROM city;

-- All columns from the park table

SELECT * FROM park;


--####################################################################################
--####################################################################################
-- SELECT __ FROM __ WHERE
-- Write queries to retrieve...

-- The names of cities in California (CA)

SELECT city_name
FROM city
WHERE state_abbreviation = 'CA';

-- The names and state abbreviations of cities NOT in California

SELECT city_name, state_abbreviation
FROM city
WHERE state_abbreviation <> 'CA';

-- The names and areas of cities smaller than 25 square kilometers 

SELECT city_name, area
FROM city
WHERE area < 25;

-- The names from all records in the state table that have no assigned census region

SELECT state_name
FROM state
WHERE census_region IS NULL;

-- The names and census regions from all records in the state table that have an assigned census region

SELECT state_name, census_region
FROM state
WHERE census_region IS NOT NULL;


--####################################################################################
--####################################################################################
-- WHERE with AND/OR
-- Write queries to retrieve...

-- The names, areas, and populations of cities smaller than 25 sq. km. with more than 100,000 people

SELECT city_name, area, population
FROM city
WHERE area < 25 AND population > 100000;

-- The names and census regions of all states (and territories and districts) not in the Midwest region (including those that don't have any census region)

SELECT state_name, census_region
FROM state
WHERE census_region <> 'Midwest' OR census_region IS NULL;

-- The names, areas, and populations of cities in California (CA) or Florida (FL)

SELECT city_name, area, population
FROM city
WHERE state_abbreviation = 'CA' OR state_abbreviation = 'FL';

-- The names, areas, and populations of cities in New England -- Connecticut (CT), Maine (ME), Massachusetts (MA), New Hampshire (NH), Rhode Island (RI) and Vermont (VT)

SELECT city_name, area, population
FROM city
WHERE state_abbreviation IN ('CT', 'ME', 'MA', 'NH', 'RI', 'VT');


--####################################################################################
--####################################################################################
-- SELECT statements involving math
-- Write a query to retrieve the names and areas of all parks in square METERS
-- (the values in the database are stored in square kilometers)
-- Label the second column "area_in_square_meters"

SELECT park_name, (area * 1000000) AS area_in_square_meters
FROM park;



--####################################################################################
--####################################################################################
-- All values vs. distinct values
-- Write a query to retrieve the names of all cities and notice repeats (like Springfield and Columbus)

SELECT city_name
FROM city;

-- Do it again, but without the repeats (note the difference in row count)

SELECT DISTINCT city_name
FROM city;


--####################################################################################
--####################################################################################
-- LIKE
-- Write queries to retrieve...

-- The names of all cities that begin with the letter "A"

SELECT city_name
FROM city
WHERE city_name LIKE 'A%';

-- The names of all cities that end with "Falls"

SELECT city_name
FROM city
WHERE city_name LIKE '% Falls';

-- The names of all cities that contain a space

SELECT city_name
FROM city
WHERE city_name LIKE '% %';


--####################################################################################
--####################################################################################
-- BETWEEN
-- Write a query to retrieve the names and areas of parks of at least 100 sq. kilometers but no more than 200 sq. kilometers

SELECT park_name, area
FROM park
WHERE area BETWEEN 100 AND 200;


--####################################################################################
--####################################################################################
-- DATES
-- Write a query to retrieve the names and dates established of parks established before 1900

SELECT park_name, date_established
FROM park
WHERE date_established < '1/1/1900';



--####################################################################################
--####################################################################################
-- Ordering

SELECT name AS country_name FROM country;

SELECT name, population, area 
    FROM country 
    ORDER BY population;

SELECT continent, name 
    FROM country 
    ORDER BY continent ASC, name ASC;


SELECT code, name, continent
    FROM country
    WHERE continent = 'North America'
    ORDER BY name;


-- Get all national parks established on Nov 10, 1978
SELECT park_name, date_established
    FROM park
    WHERE date_established = '1978-11-10'
    ORDER BY park_name;

-- Get all national parks established before the 1900s
SELECT park_name, date_established
    FROM park
    WHERE date_established < '1900-01-01'
    ORDER BY park_name;

-- Get all national parks established in the year 2000 or later
SELECT park_name, date_established
    FROM park
    WHERE date_established >= '2000-01-01'
    ORDER BY park_name;

-- Get all national parks established between Jan 1 1990 and Dec 31 1999, inclusive
SELECT park_name, date_established
    FROM park
    WHERE date_established BETWEEN '1990-01-01' AND '1999-12-31'
    ORDER BY park_name;


--==================================================================
-- ORDERING RESULTS


-- Populations of all states from largest to smallest.
select population, state_name
from public.state
order by population DESC;


-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
select census_region,state_name
from state
order by state.census_region , state.state_name DESC;

-- The biggest park by area
select park_name, area
from park 
order by area desc;


--####################################################################################
--####################################################################################
-- LIMITING RESULTS

-- The 10 largest cities by populations
select city_name, population
from public.city
order by population desc
limit 10;


-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
select date_established, park_name, CURRENT_DATE - date_established as AGE
from park
order by CURRENT_DATE - date_established desc, park_name ASC
limit 20;


--####################################################################################
--####################################################################################
-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
select city_name || ' - ' || state_abbreviation
from city;


--####################################################################################
--####################################################################################
-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
select MIN(population)
from state
where census_region is not null;

select * from state order by state.population asc limit 20;

-- Total population in the West and South census regions
--select sum(population), min(census_region)
select sum(population)
from state 
where state.census_region in ('West', 'South');

-- The number of cities with populations greater than 1 million
select count(city_id) as large_cities
from city
where population > 1000000;

-- The number of state nicknames.
select count(state_nickname) as num_state_nicknames
from state;

select * from state where state_nickname is NULL;

-- The area of the smallest and largest parks.
select min(area) as smalleast, max(area) as largest
from park;



--####################################################################################
--####################################################################################
-- GROUP BY
-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, count(*)
FROM city
GROUP BY state_abbreviation
order by state_abbreviation;


-- Determine the average park area depending upon whether parks allow camping or not.
select avg(area) as avg_allow_camping
from park
where has_camping = TRUE;

select avg(area) as avg_allow_camping
from park
where has_camping = FALSE;

select has_camping, avg(area) 
from park
group by has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
select state_abbreviation --, sum(population) as population
from city
group by state_abbreviation;

-- The smallest city population in each state ordered by city population.

-- AVG area of Parks gouped by year founded
select date_part('year', date_established) as year_established, count(*) as num_parks, sum(area) as area_added
from park
group by year_established
order by area_added ASC
limit 5;



--####################################################################################
--####################################################################################
-- SUBQUERIES

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
--   ordered from most cities to least.
-- Note subquery wrapped in () in the SELECT.
-- Note use of an alias on the city table. Table aliases figure prominently with JOIN statements.
SELECT COUNT(city_name) AS cities,
	(
        SELECT state_name FROM state WHERE state_abbreviation = c.state_abbreviation
    ) AS state_name
FROM city AS c
GROUP BY state_abbreviation
ORDER BY cities DESC;

-- Include the names of the smallest and largest parks
-- Note subquery wrapped in () in the FROM
-- Note aliases on park table and subquery
-- Note neither GROUP BY nor ORDER BY are required for subqueries.
SELECT park_name, area
--SELECT park_name, area, (CASE WHEN area = sl.smallest THEN 'Smallest' ELSE 'Largest' END) AS size
FROM park p,
	(
		SELECT MIN(area) AS smallest, MAX(area) AS largest
		FROM park
		WHERE area > 0
	) as sl
WHERE p.area = sl.smallest OR p.area = sl.largest;

-- List the capital cities for the states in the Northeast census region.
-- Note the subquery wrapped in () in the WHERE
-- Note the outer SELECT is FROM city, the inner subquery is FROM state
-- Note there is no aliasing required anywhere in the statement.
SELECT state_abbreviation, city_name
FROM city
WHERE city_id IN 
    (
        SELECT capital
        FROM state
        WHERE census_region = 'Northeast'
    )
ORDER BY state_abbreviation;

-- ALTERNATE to previous example producing the same results.
-- Note the subquery wrapped in () in the SELECT
-- Note the outer SELECT is FROM state, the inner subquery is FROM city
-- Note added alias for the sheer joy of it!
SELECT s.state_abbreviation,
	(SELECT c.city_name FROM city AS c WHERE c.city_id = s.capital)
FROM state AS s
WHERE s.census_region = 'Northeast'
ORDER BY s.state_abbreviation;
