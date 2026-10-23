-- SQL Script to create and populate tables for the 5COSC020W Lecture 05

-- Drop the tables in case they already exist
DROP TABLE IF EXISTS Device;
DROP TABLE IF EXISTS Emp;
DROP TABLE IF EXISTS Dept;

-- Create the Dept table
CREATE TABLE Dept
(
	deptNo		INTEGER,
	dName		VARCHAR(20) UNIQUE NOT NULL,
	dLoc		VARCHAR(30) NOT NULL,
	createDate	DATE,
	constraint 	d_dno_pk PRIMARY KEY (deptNo)
);

-- Create the Emp table
CREATE TABLE Emp
(
	empId		INTEGER,
	fName		VARCHAR(50) 	NOT NULL,
	lName		VARCHAR(50) 	NOT NULL,
	position 	VARCHAR(50) 	NOT NULL,
	hireDate	DATE 			NOT NULL, 
	salary		DECIMAL(7,2) 	NOT NULL,
	commPct		DECIMAL(2,2),
	email		VARCHAR(100) 	UNIQUE NOT NULL, 	
	deptNo		INT,
	constraint 	e_eid_pk PRIMARY KEY (empId),
	constraint 	e_dno_fk FOREIGN KEY (deptNo) references Dept(deptNo)
);

-- Populate the Dept table
INSERT INTO 
Dept (deptNo, dName, dLoc, createDate)
VALUES
(10, 'Database Management', 'New Cav', '2021-03-21'),
(20, 'Systems Design', 'Harrow', '2021-01-06'),
(30, 'IT Development', 'New Cav', '2021-04-25'),
(40, 'Project Management', 'Regents', '2021-02-12'),
(50, 'Systems Testing', 'Marylebone', NULL);

-- Populate the Emp table
INSERT INTO 
Emp (empId, fName, lName, position, hireDate, salary, commPct, email, deptNo)
VALUES
(101, 'Joe', 'Bloggs', 'Project Manager', '2021-03-01', 5200.00, 0.25, 'jb@it.com', 40),
(102, 'Jim', 'Marts', 'Database Admin', '2021-03-22', 4400.00, NULL, 'jm@it.com', 10),
(103, 'Jen', 'Fonts', 'Python Developer', '2021-04-28', 4800.00, 0.12, 'jf@it.com', 30),
(104, 'Jon', 'Pints', 'Database Architect', '2021-03-23', 4000.00, NULL, 'jp@it.com', 10),
(105, 'Tom', 'Dogs', 'UI Designer', '2021-01-10', 4000.00, NULL, 'td@it.com', 20),
(106, 'Tek', 'Roggs', 'Senior Project Manager', '2021-01-01', 5200.00, 0.13, 'tr@it.com', 40),
(107, 'Tim', 'Clogs', 'Java Developer', '2021-04-29', 4300.00, 0.15, 'tc@it.com', NULL),
(108, 'Tam', 'Kelps', 'UX Designer', '2021-01-15', 3900.00, NULL, 'tk@it.com', NULL);
