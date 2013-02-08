--CREATE DATABASE IF NOT EXISTS smartshop;
--GRANT ALL PRIVILEGES ON smartshop.* TO smartshop@localhost IDENTIFIED BY 'pc';

USE smartshop;
alter table Product_Supplier drop foreign key FKBA8235CDC2426B0;
alter table Product_Supplier drop foreign key FKBA8235C4BF6FC89;
alter table Supplier drop foreign key FKA0B65DEC172E269;
drop table if exists Address;
drop table if exists Product;
drop table if exists Product_Supplier;
drop table if exists Supplier;
create table Address (id integer not null, PhoneNumber1 bigint, PhoneNumber2 bigint, addressLine1 varchar(255), addressLine2 varchar(255), city varchar(255), country varchar(255), email1 varchar(255), email2 varchar(255), state varchar(255), zipcode bigint, primary key (id)) ENGINE=InnoDB;
create table Product (id integer not null, description varchar(255), name varchar(255), otherDetails varchar(255), sellingUnit varchar(255), unitPrice double precision, primary key (id)) ENGINE=InnoDB;
create table Product_Supplier (Product_id integer not null, suppliers_id integer not null) ENGINE=InnoDB;
create table Supplier (id integer not null, name varchar(255), otherDetails varchar(255), address_id integer, primary key (id)) ENGINE=InnoDB;
alter table Product_Supplier add index FKBA8235CDC2426B0 (suppliers_id), add constraint FKBA8235CDC2426B0 foreign key (suppliers_id) references Supplier (id);
alter table Product_Supplier add index FKBA8235C4BF6FC89 (Product_id), add constraint FKBA8235C4BF6FC89 foreign key (Product_id) references Product (id);
alter table Supplier add index FKA0B65DEC172E269 (address_id), add constraint FKA0B65DEC172E269 foreign key (address_id) references Address (id);
