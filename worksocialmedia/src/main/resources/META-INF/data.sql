DROP TABLE IF EXISTS user CASCADE;
DROP TABLE IF EXISTS job CASCADE;
DROP TABLE IF EXISTS company CASCADE;
DROP TABLE IF EXISTS work;
DROP TABLE IF EXISTS friend;
DROP TABLE IF EXISTS address;


CREATE TABLE user (id INT AUTO_INCREMENT  PRIMARY KEY, first_name VARCHAR(250) NOT NULL, last_name VARCHAR(250) NOT NULL, gender VARCHAR(250) NOT NULL, birth_date VARCHAR(250) NOT NULL, residential_address INT(11) NOT NULL);
CREATE TABLE job (id INT AUTO_INCREMENT  PRIMARY KEY, name VARCHAR(250) NOT NULL, category VARCHAR(250) NOT NULL, description VARCHAR(250) NOT NULL);
CREATE TABLE company (id INT AUTO_INCREMENT  PRIMARY KEY, name VARCHAR(250) NOT NULL, CEO VARCHAR(250) NOT NULL, number_employees INT(20) NOT NULL, foundation_year VARCHAR(250) NOT NULL, description VARCHAR(500) NOT NULL, legal_address INT(11) NOT NULL);
CREATE TABLE work (id INT AUTO_INCREMENT  PRIMARY KEY, user INT(11) NOT NULL, company INT(11) NOT NULL, job INT(11) NOT NULL, salary INT(20) NOT NULL, start_date VARCHAR(250) NOT NULL, end_date VARCHAR(250) NOT NULL);
CREATE TABLE friend (id INT AUTO_INCREMENT  PRIMARY KEY, user1 INT(11) NOT NULL, user2 INT(11) NOT NULL, creation_date VARCHAR(250) NOT NULL);
CREATE TABLE address (id INT AUTO_INCREMENT  PRIMARY KEY, street VARCHAR(250) NOT NULL, municipality VARCHAR(250) NOT NULL, civic_number VARCHAR(250), postal_code VARCHAR(250) NOT NULL, nation VARCHAR(250) NOT NULL, dtype VARCHAR(250) NOT NULL);


INSERT INTO user (first_name, last_name, gender,  birth_date, residential_address) VALUES ('John', 'Brown', 'Male', '12/12/1975', 1);
INSERT INTO user (first_name, last_name, gender,  birth_date, residential_address) VALUES ('Laura', 'Johnson', 'Female', '16/03/1964', 3);
INSERT INTO user (first_name, last_name, gender,  birth_date, residential_address) VALUES('Anne', 'Moses', 'Female', '13/08/1983', 5);

INSERT INTO job (name, category, description) VALUES ('Teacher', 'impiegati', 'teach kids');
INSERT INTO job (name, category, description) VALUES('Driver', 'impiegati', 'drives a vehicle');
INSERT INTO job (name, category, description) VALUES('Programmer', 'impiegati', 'writes code');
INSERT INTO job (name, category, description) VALUES('Data scientist', 'impiegati', 'processes big data');
INSERT INTO job (name, category, description) VALUES('Actor', 'impiegati', 'plays in a movie');

INSERT INTO company (name, CEO, number_employees,  foundation_year, description, legal_address) VALUES('Microsoft', 'Bill Gates', 10000, '13/08/1983', 'Tech company', 2);
INSERT INTO company (name, CEO, number_employees,  foundation_year, description, legal_address) VALUES('Facebook', 'Mark Zuckemberg', 4000, '11/08/2000', 'Tech company', 2);
INSERT INTO company (name, CEO, number_employees,  foundation_year, description, legal_address) VALUES('Brembo', 'Daniele Schillaci', 1000, '16/03/1973', 'Brakes company', 4);

INSERT INTO work (user, company, job, salary, start_date, end_date) VALUES(1, 1, 1, 20000, '12/01/2016', '12/01/2017');
INSERT INTO work (user, company, job, salary, start_date, end_date) VALUES(2, 2, 4, 50000, '13/05/2012', '18/06/2018');
INSERT INTO work (user, company, job, salary, start_date, end_date) VALUES(3, 1, 5, 35000, '23/10/2013', '1/1/2014');

INSERT INTO friend (user1, user2, creation_date) VALUES(1, 2, '28/10/2013');
INSERT INTO friend (user1, user2, creation_date) VALUES(1, 3, '23/08/2015');
INSERT INTO friend (user1, user2, creation_date) VALUES(3, 2, '12/04/2016');

INSERT INTO address (street, municipality, civic_number, postal_code, nation, dtype) VALUES('Via Marco Polo', 'Roma', '1', '20125', 'Italy', 'AddressUser');
INSERT INTO address (street, municipality, civic_number, postal_code, nation, dtype) VALUES('Via Silvio Pellico', 'Milano', '', '20125', 'Italy', 'AddressCompany');
INSERT INTO address (street, municipality, civic_number, postal_code, nation, dtype) VALUES('Viale Forlanini', 'Roma', '13', '00100', 'Italy', 'AddressUser');
INSERT INTO address (street, municipality, civic_number, postal_code, nation, dtype) VALUES('Via Cavour', 'Milano', '7', '20125', 'Italy', 'AddressCompany');
INSERT INTO address (street, municipality, civic_number, postal_code, nation, dtype) VALUES('Via Pasubio', 'Milano', '53', '20125', 'Italy', 'AddressUser');
