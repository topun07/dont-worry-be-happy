DROP TABLE IF EXISTS drivers, cars CASCADE;

create table drivers
(
	id serial primary key,
	name varchar(100),
	age int
);

create table cars
(
	id serial primary key,
	make varchar(100),
	model varchar(100),
	year int,
	driver_id int references drivers(id)
);

-- Insert data into drivers table
INSERT INTO drivers (id, name, age) VALUES
    (1,'Alice Johnson', 32),
    (2,'Bob Smith', 45),
    (3,'Charlie Brown', 28),
    (4,'David Wilson', 39),
    (5,'Eve Davis', 23);

-- Insert data into cars table
INSERT INTO cars (id, make, model, year, driver_id) VALUES
    (1,'Toyota', 'Camry', 2020, 1),  -- Assigning to Alice Johnson
    (2,'Ford', 'Mustang', 2019, 2),  -- Assigning to Bob Smith
    (3,'Honda', 'Civic', 2021, 3);   -- Assigning to Charlie Brown
