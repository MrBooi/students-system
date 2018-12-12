drop table if exists scores, students;
create table students (
id serial not null primary key,
name text not null UNIQUE,
surname text not null,
age int not null,
email text not null 

);

create table scores (
id serial not null primary key,
student_id int not null ,
score int DEFAULT 0,
added_date DATE not NULL DEFAULT CURRENT_DATE,
foreign key (student_id) references students(id)
);   

INSERT INTO students (name,surname,age,email) VALUES ('Ayabonga','Booi',15,'aya@gmail.com');
INSERT INTO students (name,surname,age,email) VALUES ('Tony','Joke',,'Tony@gmail.com');

