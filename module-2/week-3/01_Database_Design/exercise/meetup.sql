CREATE TABLE Artist (
    Artist_ID INT PRIMARY KEY,
    last_name VARCHAR(50),
    first_name VARCHAR(50)
);

-- Insert data into Artist
INSERT INTO Artist (Artist_ID, Last_Name, First_Name) VALUES
(101, 'Halen', 'Eddie'),
(102, 'Hendrix', 'Jimi'),
(103, 'Clapton', 'Eric'),
(104, 'Page', 'Jimmy'),
(105, 'Vaughn', 'Stevie Ray'),
(106, 'Gilmour', 'David'),
(107, 'King', 'B.B'),
(108, 'Prince', '');

--select *
--from artist;

CREATE TABLE Interest_Group (
    Interest_Group_ID INT PRIMARY KEY,
    Name VARCHAR(100)
);

-- Insert data into Interest_Group
INSERT INTO Interest_Group (Interest_Group_ID, Name) VALUES
(201, 'All Generations'),
(202, '70s'),
(203, '60s and 70s'),
(204, '60s and before');

--select *
--from interest_group;

CREATE TABLE Event (
    Event_ID INT PRIMARY KEY,
    Event_Name VARCHAR(100),
    Description TEXT,
    Start_Time TIME,
    Start_Date DATE,
    Duration_Hours INT,
    Interest_Group_ID INT REFERENCES Interest_Group
   );

-- Insert data into Event
INSERT INTO Event (Event_ID, Event_Name, Description, Start_Time, Start_Date, Duration_Hours, Interest_Group_ID) VALUES
(301, 'Lollapalooza', 'All Generations', '05:00', '1988-03-02', 10, 201),
(302, 'Woodstock', 'All Generations', '05:00', '1988-03-03', 11, 202),
(303, 'Monsters of Rock', 'Metal 90s', '05:00', '1988-03-04', 12, 203),
(304, 'Blues Festival', '60s and 70s', '05:00', '1988-03-05', 13, 204),
(305, 'October Fest', 'All Generations', '05:00', '1988-03-07', 14, 201),
(306, 'Red Bull Festival', 'Metal 80s and 90s', '05:00', '1988-03-08', 15, 202),
(307, 'Metal Fest', 'Metal 90s', '05:00', '1988-03-09', 16, 203),
(308, 'KnotFest', 'Metal 90s', '05:00', '1988-03-09', 17, 204);

--select * 
--from event;

CREATE TABLE Contact_Information (
    Artist_ID INT references Artist PRIMARY KEY,
    Email VARCHAR(100),
    Phone_Number VARCHAR(20),
    date_of_show DATE,
    Want_Reminder_Emails boolean
);

-- Insert data into Contact_Information
INSERT INTO Contact_Information (Artist_ID, Email, Phone_Number, date_of_show, Want_Reminder_Emails) VALUES
(101, 'halen@rockyourpantsoff.com', NULL, '1964-02-09', false),
(102, 'hendrix@rockyourpantsoff.com', '10-203-293', '1988-02-05', true),
(103, 'clapton@rockyourpantsoff.com', '10-223-334', '1933-03-04', true),
(104, 'page@rockyourpantsoff.com', '82-999-024', '1984-03-05', false),
(105, 'vaughn@rockyourpantsoff.com', '12-600-004', '1983-02-24', true),
(106, 'floyd@rockyourpantsoff.com', '20-003-285', '1983-02-24', true),
(107, 'king@rockyourpantsoff.com', '22-004-128', '1923-04-01', false),
(108, 'prince@rockyourpantsoff.com', '22-333-004', '1903-02-04', true);

--select * 
--from contact_information;

CREATE TABLE Who_Is_Playing (
    Event_ID INT REFERENCES Event,
    Artist_ID INT REFERENCES Artist 
);

-- Insert data into WhosPlaying
INSERT INTO Who_is_Playing (Event_ID, Artist_ID) VALUES
(301, 101), (301, 108),
(302, 102), (302, 103), (302, 105),
(303, 104), (303, 106), (303, 107),
(304, 101), (304, 102), (304, 103), (304, 104), (304, 105), (304, 107),
(305, 101), (305, 106), (305, 108),
(306, 101), (306, 105),
(307, 101),
(308, 101);

--select *
--from who_is_playing;

create table Artist_to_interest_group (
artist_id int references artist,
	interest_group_id int references interest_group
);

insert into artist_to_interest_group (artist_id, interest_group_id) values
(101, 201),
(102, 201),
(103, 201),
(104, 201),
(105, 201),
(106, 201),
(107, 201),
(108, 201),
(105, 202),
(106, 202),
(108, 202),
(101, 202),
(102, 203),
(103, 203),
(104, 203),
(107, 204);

--select *
--from artist_to_interest_group;
