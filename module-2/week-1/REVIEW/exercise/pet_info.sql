create table pet_owner
(owner_id serial primary key, 
 owner_name varchar(50)
);
insert into pet_owner (owner_name) values
('sam cook'),
('terry kim');
--select * 
--from pet_owner;

create table pet
(pet_id int primary key, 
 pet_name varchar(50), 
 pet_age int, 
 pet_type varchar(50), 
 owner_id int references pet_owner(owner_id)
);
insert into pet
(pet_id, pet_name, pet_age, pet_type) values 
(246, 'rover', 12, 'dog'),
(298, 'spot', 2, 'dog'),
(341, 'morris', 4, 'cat'),
(519, 'tweedy', 2, 'bird');
--select *
--from pet;


create table procedure(
	procedure_id serial primary key, 
	pet_id int references pet (pet_id),
	visit_date date, 
	procedure varchar(50)
);
insert into procedure 
(visit_date, procedure) values
('1/13/2002', '01 - Rabies vaccination'),
('3/27/2002', '10 - Examine and Treat wound'),
('4/2/2002', '05 - Heart worm test'),
 ('1/21/2002', '08 - Tetnus vaccination'),
 ('3/10/2002', '05 - Heart worm test'),
 ('1/23/2001', '01 - Rabies vaccination'),
 ('1/13/2002', '01 - Rabies vaccination'),
 ('4/30/2002', '20 - Annual checkup'),
 ('4/30/2002', '12 - Eye wash');
