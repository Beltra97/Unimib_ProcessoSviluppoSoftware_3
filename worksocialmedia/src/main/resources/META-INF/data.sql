DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS job;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS work;


CREATE TABLE user (id INT AUTO_INCREMENT  PRIMARY KEY, first_name VARCHAR(250) NOT NULL, last_name VARCHAR(250) NOT NULL, gender VARCHAR(250) NOT NULL, birth_date VARCHAR(250) NOT NULL);
CREATE TABLE job (id INT AUTO_INCREMENT  PRIMARY KEY, name VARCHAR(250) NOT NULL, category VARCHAR(250) NOT NULL, description VARCHAR(250) NOT NULL);
CREATE TABLE company (id INT AUTO_INCREMENT  PRIMARY KEY, name VARCHAR(250) NOT NULL, CEO VARCHAR(250) NOT NULL, number_employees INT(11) NOT NULL, foundation_year VARCHAR(250) NOT NULL, description VARCHAR(250) NOT NULL);
CREATE TABLE work (id INT AUTO_INCREMENT  PRIMARY KEY, user INT(11) NOT NULL, company INT(11) NOT NULL, job_type INT(11) NOT NULL, salary INT(11) NOT NULL, start_date VARCHAR(250) NOT NULL, end_date VARCHAR(250) NOT NULL);


INSERT INTO user (first_name, last_name, gender,  birth_date) VALUES ('John', 'Brown', 'Male', '12/12/1975');
INSERT INTO user (first_name, last_name, gender,  birth_date) VALUES ('Laura', 'Johnson', 'Female', '16/03/1964');
INSERT INTO user (first_name, last_name, gender,  birth_date) VALUES('Anne', 'Moses', 'Female', '13/08/1983');

INSERT INTO job (name, category, description) VALUES ('Teacher', 'impiegati', 'teach kids');
INSERT INTO job (name, category, description) VALUES('Driver', 'impiegati', 'drives a vehicle');
INSERT INTO job (name, category, description) VALUES('Programmer', 'impiegati', 'writes code');
INSERT INTO job (name, category, description) VALUES('Data scientist', 'impiegati', 'processes big data');
INSERT INTO job (name, category, description) VALUES('Actor', 'impiegati', 'plays in a movie');

INSERT INTO company (name, CEO, number_employees,  foundation_year, description) VALUES('Microsoft', 'Bill Gates', 10000, '13/08/1983', 'Tech company');
INSERT INTO company (name, CEO, number_employees,  foundation_year, description) VALUES('Facebook', 'Mark Zuckemberg', 4000, '11/08/2000', 'Tech company');

INSERT INTO work (user, company, job_type, salary, start_date, end_date) VALUES(1, 1, 1, 20000, 12/1/2016, 12/1/2017);
INSERT INTO work (user, company, job_type, salary, start_date, end_date) VALUES(2, 1, 1, 20000, 12/1/2016, 12/1/2017);
