DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS CONVERSIONFACTOR;
create table student
(
   id integer not null,
   name varchar(255) not null,
   passport_number DOUBLE not null,
   primary key(id)
);


create table CONVERSIONFACTOR
(
   id integer not null,
   CONTRY_CODE varchar(255) not null,
   CONVERT_FACT DOUBLE not null,
   primary key(id)
);