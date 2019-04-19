-- Registros de padres
insert into parents(parent_id,gender,first_name,middle_name,last_name,other_parent_details) values
(1,'M','Artemio','Hipolito','Gamarra','Padre');
insert into parents(parent_id,gender,first_name,middle_name,last_name,other_parent_details) values
(2,'F','Sofia','Fortunata','Astocondor','Madre');
insert into parents(parent_id,gender,first_name,middle_name,last_name,other_parent_details) values
(3,'M','Gustavo','Gilberto','Diaz','Padre');
insert into parents(parent_id,gender,first_name,middle_name,last_name,other_parent_details) values
(4,'F','Juana','Dina','Fuertes','Madre');
insert into parents(parent_id,gender,first_name,middle_name,last_name,other_parent_details) values
(5,'M','Juan','Carlos','Quispe','Padre');

-- Registros de familias
insert into families(family_id,head_of_family_parent_id,family_name) values(1,1,'Familia Gamarra');
--insert into families(family_id,head_of_family_parent_id,family_name) values(2,2,'Familia Gamarra');
insert into families(family_id,head_of_family_parent_id,family_name) values(2,3,'Familia Diaz');
insert into families(family_id,head_of_family_parent_id,family_name) values(3,4,'Familia Fuertes');
insert into families(family_id,head_of_family_parent_id,family_name) values(4,5,'Familia Quispe');

-- Registros de estudiantes
insert into students(student_id,gender,first_name,middle_name,last_name,date_of_birth,other_student_details)values
(1,'M','Luis','Alberto','Gamarra','1994-09-20','Estudiante familia Gamarra');
insert into students(student_id,gender,first_name,middle_name,last_name,date_of_birth,other_student_details)values
(2,'M','Oscar','Artemio','Gamarra','1992-06-10','Estudiante familia Gamarra');
insert into students(student_id,gender,first_name,middle_name,last_name,date_of_birth,other_student_details)values
(3,'F','Noelia','Elizabeth','Diaz','1994-10-15','Estudiante familia Diaz');
insert into students(student_id,gender,first_name,middle_name,last_name,date_of_birth,other_student_details)values
(4,'M','Andy','Gustavo','Fuertes','1998-07-22','Estudiante familia Fuertes');
insert into students(student_id,gender,first_name,middle_name,last_name,date_of_birth,other_student_details)values
(5,'M','Alex','Frank','Fuertes','1997-11-20','Estudiante familia Fuertes');
insert into students(student_id,gender,first_name,middle_name,last_name,date_of_birth,other_student_details)values
(6,'F','Antonella','Sofia','Quispe','2015-01-05','Estudiante familia Quispe');
insert into students(student_id,gender,first_name,middle_name,last_name,date_of_birth,other_student_details)values
(7,'F','Rafaella','Esmeralda','Quispe','2017-04-16','Estudiante familia Quispe');

-- Registros de estudiantes y padres
insert into student_parents(student_id,parent_id) values(1,1);
insert into student_parents(student_id,parent_id) values(2,1);
insert into student_parents(student_id,parent_id) values(3,3);
insert into student_parents(student_id,parent_id) values(4,4);
insert into student_parents(student_id,parent_id) values(5,4);
insert into student_parents(student_id,parent_id) values(6,5);
insert into student_parents(student_id,parent_id) values(7,5);

-- Regsitro de miembros de familias
insert into family_members(family_member_id,family_id,parent_or_student_member,parent_id,student_id)
values(1,1,'student',null,1);
insert into family_members(family_member_id,family_id,parent_or_student_member,parent_id,student_id)
values(2,1,'student',null,2);
insert into family_members(family_member_id,family_id,parent_or_student_member,parent_id,student_id)
values(3,3,'student',null,3);
insert into family_members(family_member_id,family_id,parent_or_student_member,parent_id,student_id)
values(4,4,'Parent',4,null);
insert into family_members(family_member_id,family_id,parent_or_student_member,parent_id,student_id)
values(5,4,'student',null,5);
insert into family_members(family_member_id,family_id,parent_or_student_member,parent_id,student_id)
values(6,1,'Parent',2,null);