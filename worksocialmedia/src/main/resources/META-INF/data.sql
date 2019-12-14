DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS job;
 
CREATE TABLE user (id INT AUTO_INCREMENT  PRIMARY KEY, first_name VARCHAR(250) NOT NULL, last_name VARCHAR(250) NOT NULL, job_id INT(11) NOT NULL);
CREATE TABLE job (id INT AUTO_INCREMENT  PRIMARY KEY, job_name VARCHAR(250) NOT NULL, job_salary INT(11) NOT NULL);

INSERT INTO user (first_name, last_name, job_id) VALUES ('Keanu', 'Reeves', 5);
INSERT INTO user (first_name, last_name, job_id) VALUES ('Laurence', 'Fishburne', 5);
INSERT INTO user (first_name, last_name, job_id) VALUES('Carrie-Anne', 'Moss', 3);

INSERT INTO job (job_name, job_salary) VALUES ('Teacher', 30000);
INSERT INTO job (job_name, job_salary) VALUES('Driver', 40000);
INSERT INTO job (job_name, job_salary) VALUES('Programmer', 35000);
INSERT INTO job (job_name, job_salary) VALUES('Data scientist', 80000);
INSERT INTO job (job_name, job_salary) VALUES('Actor', 50000);