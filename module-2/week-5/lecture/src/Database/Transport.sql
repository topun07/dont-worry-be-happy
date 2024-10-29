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
)