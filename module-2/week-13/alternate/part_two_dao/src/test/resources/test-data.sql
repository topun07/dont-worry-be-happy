BEGIN TRANSACTION;

DROP TABLE IF EXISTS movie_genre, movie_screenwriter, genre, movie, person CASCADE;

CREATE TABLE genre (
	genre_id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

CREATE TABLE person (
	person_id SERIAL PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	birthdate DATE NOT NULL,
	deathdate DATE NULL
);

CREATE TABLE movie (
	movie_id SERIAL PRIMARY KEY,
	title VARCHAR(100) NOT NULL,
	director_id INTEGER REFERENCES person(person_id),
	length_minutes INTEGER NOT NULL,
	release_year INTEGER NOT NULL,
	music_by_id INTEGER REFERENCES person(person_id),
	filming_country VARCHAR(50) NOT NULL
);

CREATE TABLE movie_genre (
	movie_id INTEGER REFERENCES movie(movie_id),
	genre_id INTEGER REFERENCES genre(genre_id),
	PRIMARY KEY (movie_id, genre_id)
);

CREATE TABLE movie_screenwriter (
	movie_id INTEGER REFERENCES movie(movie_id),
	screenwriter_id INTEGER REFERENCES person(person_id),
	PRIMARY KEY (movie_id, screenwriter_id)
);

INSERT INTO genre (name)
VALUES
    ('Drama'),
    ('Foreign'),
    ('Thriller');

INSERT INTO person (first_name, last_name, birthdate, deathdate) VALUES
    ('Martin', 'Scorsese', '1942-11-17', NULL),
    ('Ingmar', 'Bergman', '1918-07-14', '2007-07-30'),
    ('Francois', 'Truffaut', '1932-02-06', '1984-10-21'),
    ('Akira', 'Kurosawa', '1910-03-23', '1998-09-06'),
    ('Michelangelo', 'Antonioni', '1912-09-29', '2007-07-30'),
    ('Woody', 'Allen', '1935-12-01', NULL),
    ('Mel', 'Brooks', '1926-06-28', NULL);

INSERT INTO movie (title, release_year, length_minutes, filming_country, music_by_id, director_id)
VALUES
    ('Taxi Driver', 1976, 114, 'USA', 5, 1),
    ('Cries and Whispers', 1972, 91, 'Sweden', 1, 2),
    ('8 1/2', 1963, 138, 'Italy', 6, 4),
    ('The 400 Blows', 1959, 100, 'France', NULL, 3);

INSERT INTO movie_genre (movie_id, genre_id)
VALUES
    (1, 1),
    (1, 3),
    (2, 1),
    (2, 2),
    (3, 1),
    (3, 2),
    (4, 1);

INSERT INTO movie_screenwriter (movie_id, screenwriter_id) VALUES
    (1, 1),
    (2, 2),
    (3, 4),
    (4, 3),
    (4, 4),
    (4, 5),
    (2, 7),
    (1, 6);

COMMIT;
