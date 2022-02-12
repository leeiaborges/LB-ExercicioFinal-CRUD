

create table ipva (
id_ipva int(3) NOT NULL AUTO_INCREMENT,
ano int(4) NOT NULL,
PRIMARY KEY (id_ipva)
);

create table carros (
id int(3) NOT NULL AUTO_INCREMENT,
modelo varchar (120) NOT NULL,
ano int(4) NOT NULL,
id_ipva int(3) NULL,
PRIMARY KEY (id),
FOREIGN key(id_ipva) REFERENCES	ipva (id_ipva)
);

drop table carros;
drop table ipva;
select * from carros;
select * from ipva;

show tables;