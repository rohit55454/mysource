drop table if Exists customers;

CREATE TABLE customers (
  cid int(11) primary key AUTO_INCREMENT,
  cname varchar(12) ,
  email varchar(55) ,
  city varchar(25) ,
  cardbal double ,
  cardtype varchar(10),
  cardno int,
  status varchar(10)
);


insert into customers values(101,'sri','sri@jlc','Blore',20000,'visa',1234,'ACTIVE');
insert into customers values(102,'vas','vas@jlc','Blore',30000,'visa',1235,'ACTIVE');
insert into customers values(103,'aa','aa@jlc','Blore',10000,'visa',1236,'ACTIVE');
insert into customers values(104,'bb','bb@jlc','Delhi',10000,'visa',1237,'ACTIVE');
insert into customers values(105,'cc','cc@jlc','Delhi',35000,'master',1238,'ACTIVE');
insert into customers values(106,'dd','dd@jlc','Hyd',45000,'master',1239,'ACTIVE');
insert into customers values(107,'ee','ee@jlc','Blore',25000,'visa',1240,'INACTIVE');
insert into customers values(108,'ff','ff@jlc','Hyd',25000,'visa',1241,'ACTIVE');
