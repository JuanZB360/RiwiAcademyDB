DROP DATABASE IF EXISTS RiwiAcademyDB;

CREATE DATABASE RiwiAcademyDB;

USE RiwiAcademyDB;

CREATE TABLE student(
	id int auto_increment primary key,
    name varchar(50) not null,
    email varchar(50) unique not null,
    state boolean default TRUE
);

CREATE TABLE course(
	id int auto_increment primary key,
    name varchar(50) unique not null
);

CREATE TABLE inscription(
	id int auto_increment primary key,
    student_id int not null,
    course_id int not null,
    constraint fk_student_registration foreign key (student_id) references student (id),
    constraint fk_course_registration foreign key (course_id) references course (id)
);

CREATE TABLE ratings(
	id int auto_increment primary key,
    student_id int not null,
    course_id int not null,
    rating float not null,
    description varchar(200) not null,
    constraint fk_student_ratings foreign key (student_id) references student (id),
    constraint fk_course_ratings foreign key (course_id) references course (id) on delete cascade
);

