DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS job;
DROP TABLE IF EXISTS company;
 
CREATE TABLE user (id INT AUTO_INCREMENT  PRIMARY KEY, first_name VARCHAR(250) NOT NULL, last_name VARCHAR(250) NOT NULL, gender VARCHAR(250) NOT NULL, birth_date VARCHAR(250) NOT NULL);
CREATE TABLE job (id INT AUTO_INCREMENT  PRIMARY KEY, job_name VARCHAR(250) NOT NULL, job_salary INT(11) NOT NULL);
CREATE TABLE company (id INT AUTO_INCREMENT  PRIMARY KEY, name VARCHAR(250) NOT NULL, CEO VARCHAR(250) NOT NULL, number_employees INT(11) NOT NULL, foundation_year VARCHAR(250) NOT NULL, description VARCHAR(250) NOT NULL);


INSERT INTO user (first_name, last_name, gender,  birth_date) VALUES ('John', 'Brown', 'Male', '12/12/1975');
INSERT INTO user (first_name, last_name, gender,  birth_date) VALUES ('Laura', 'Johnson', 'Female', '16/03/1964');
INSERT INTO user (first_name, last_name, gender,  birth_date) VALUES('Anne', 'Moses', 'Female', '13/08/1983');

INSERT INTO job (job_name, job_salary) VALUES ('Teacher', 30000);
INSERT INTO job (job_name, job_salary) VALUES('Driver', 40000);
INSERT INTO job (job_name, job_salary) VALUES('Programmer', 35000);
INSERT INTO job (job_name, job_salary) VALUES('Data scientist', 80000);
INSERT INTO job (job_name, job_salary) VALUES('Actor', 50000);

INSERT INTO company (name, CEO, number_employees,  foundation_year, description) VALUES('Microsoft', 'Bill Gates', 10000, '13/08/1983', 'Tech company');
INSERT INTO company (name, CEO, number_employees,  foundation_year, description) VALUES('Facebook', 'Mark Zuckemberg', 4000, '11/08/2000', 'Tech company');
