
create table Parents(
	parent_id serial primary key,
	gender varchar(15) not null,
	first_name varchar(100) not null,
	middle_name varchar(100) not null,
	last_name varchar(100) not null,
	other_parent_details varchar(100) null
);

create table Families(
	family_id serial primary key,
	head_of_family_parent_id integer not null,
	family_name varchar(100) not null,
	FOREIGN KEY(head_of_family_parent_id) REFERENCES Parents(parent_id) ON DELETE CASCADE
);

create table Students(
	student_id serial primary key,
	gender varchar(15) not null,
	first_name varchar(100) not null,
	middle_name varchar(100) not null,
	last_name varchar(100) not null,
	date_of_birth date not null,
	other_student_details varchar(100) null
);


create table Student_Parents(
	student_id int null , -- cambio
	parent_id int null , --cambio
	PRIMARY KEY(student_id,parent_id),
	FOREIGN KEY(student_id) REFERENCES Students(student_id) ON DELETE CASCADE,
	FOREIGN KEY(parent_id) REFERENCES Parents(parent_id) ON DELETE CASCADE
);


create table Family_Members(
	family_member_id serial primary key,
	family_id integer not null,
	parent_or_student_member varchar(100) not null,
	parent_id integer not null,
	student_id integer not null,
	FOREIGN KEY(family_id) REFERENCES Families(family_id) ON DELETE CASCADE,
	FOREIGN KEY(parent_id) REFERENCES Parents(parent_id) ON DELETE CASCADE,
	FOREIGN KEY(student_id) REFERENCES Students(student_id) ON DELETE CASCADE
);