create database user;
use user;

create table user(
id int not null auto_increment primary key,
name varchar(200) not null,
email varchar(200) not null,
country varchar(200) not null
);

insert into user(name, email, country) values
("Thu Hà" , "thuha@gmail.com","Việt Nam"),
("Yến Nhi" , "yennhi@gmail.com","Việt Nam"),
("Anh Thư" , "anhthu@gmail.com","Việt Nam");
 select * from user;

select * from user where id = 2 ;
select * from user;

delete from user where id = 3 ;
select * from user;
 
update user set name = "Yến Nhi 1" , email = "nhi@gmail.com" , country = "UK" where id = 1 ;
select * from user;