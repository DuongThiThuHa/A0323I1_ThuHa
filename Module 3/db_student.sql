create database student;
use student;

create table student(
id int not null auto_increment primary key,
name varchar(200),
dateOfBirth varchar(100),
address varchar(200),
email varchar(200)
);

insert into student(name,dateOfBirth,address,email) values
("Nhi","02-02-2002","Đà Nẵng","nhi@gmail.com"),
("Thư","02-03-2002","Đà Nẵng","thu@gmail.com"),
("Hà","02-04-2002","Quảng Nam","ha@gmail.com");

select * from student;


