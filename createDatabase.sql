create database hotelmanagementsystem;

show databases;

use hotelmanagementsystem;

create table login(username varchar(25),password varchar(25));

insert into login values ('devansh','12345');

select * from login;

use hotelmanagementsystem;
create table  employee(name varchar(25),age varchar(25),gender varchar(25),job varchar(25),
	salary varchar(25),phone varchar(25),email varchar(25),aadhaar varchar(25));

select * from employee;

create table  room(Room_Number varchar(5),availability varchar(25),Status varchar(25),Price varchar(25),
	Room_Type varchar(25));
    
select * from room;

SELECT * FROM room WHERE availability = 'Unoccupied';

create table  customer(Id varchar(25),Id_Number varchar(25),Name varchar(25),Gender varchar(25),Email varchar(25),Room_Number varchar(5),
	Checkin_Time varchar(100),Deposit varchar(25));
    
select * from customer;

