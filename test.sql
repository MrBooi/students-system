drop table if exists students;
create table students (
id serial not null primary key,
name text not null,
email text not null
);
