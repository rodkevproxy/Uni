-- Tutorial 06 Question 01 
 
-- Write a query that displays a list of department names alongside the cities and countries where these departments 
-- are located, for all departments in Cambridge. 
SELECT l.city, l.country, d.department_name 
FROM locations l JOIN departments d ON l.location_id 
AND l.city = 'Cambridge';

-- Tutorial 06 Question 02 
 
-- Write a query that displays a list of department names alongside the full names and salaries of the employees who 
-- work in those departments, but only for the employees who earn more than 45K and for the departments whose name 
-- start with the letter M. To avoid the issue of the capitalisation of the letter M, use UPPER to convert from lower-case 
-- to upper-case. 

SELECT d.department_name, CONCAT(e.first_name, ' ', e.last_name) AS full_name, e.salary
FROM departments d
JOIN employees e ON d.department_id = e.department_id
WHERE e.salary > 45000 
AND UPPER(d.department_name) LIKE 'M%';

 
-- Tutorial 06 Question 03  
-- Display a list of countries, cities, department names alongside the full names and salaries of the members of staff who 
-- work in those departments and cities. Do this for staff that were either hired after 2 March 2015 or who earn less than 
-- £46000. Order your output by country, city, and department name. 

SELECT l.country, l.city, d.department_name, CONCAT(e.first_name)
 
-- Tutorial 06 Question 04 
 
-- Write a query that displays a list of departments alongside the full names, hire dates and salaries of the employees 
-- who  work  in  those  departments  but  only  for  the  employees  whose  surname  starts  with  a  P  and  those  employees 
-- whose surname starts with a S. 
-- Tutorial 06 Question 05 
 
-- Write a query that displays a list of IDs, first names and surnames of the employees who manage other employees 
-- with  the  IDs,  first  names  and  surnames  of  the  employees  that  they  manage.  Rename  the  headers  of  the  columns 
-- related to the managers and the columns related to the employees to differentiate between them by using aliases. 
 
-- Tutorial 06 Question 06 
 
-- Modify  the  previous  query  to  output  only  one  column  displaying  the  details  of  the  managers  and  their  respective 
-- employees.  For every employee,  this column should display something like “Jenny Bloggs (ID: 1234) manages John 
-- Smith (ID: 5678)”. Give it an appropriate header like “Management Report”. 
 
-- Tutorial 06 Question 07 
 
-- Write a query that displays a list of employee surnames, salaries and job roles for those employees who work in the 
-- IT department. 
 
-- Tutorial 06 Question 08 
 
-- Write  a  query  that  displays  a  list  of  employee  surnames,  first  names,  salaries,  job  roles  with  the  names  of  the 
-- departments where they work and the cities and countries where these departments are located. 
 
-- Tutorial 06 Question 09 
 
-- Write a query that displays a list of employee surnames, salaries, job roles, hire dates and their department names 
-- and cities for those employees who work in London, who were hired before the 25th April 2019 and whose salary is 
-- not between 40,000 and 50,000. 
 
-- Tutorial 06 Question 10 
 
-- Write  a  query  that  displays  a  list  of  employee  surnames,  salaries,  job  roles  and  department  names  along  with  the 
-- surnames, salaries, job roles and department names of those staff who manage them. 
 
-- Tutorial 06 Question 11 
 
-- Write a query that displays a list of departments alongside the full names, hire dates and salaries of the employees 
-- who work in those departments.  To this list add the names of the departments who do not have any employees. 
 
-- Tutorial 06 Question 12 
 
-- Write a query that displays a list of departments alongside the full names, hire dates and salaries of the employees 
-- who work in those departments.  To this list add the names of the employees who do not work in a department. 
 
-- Tutorial 06 Question 13 
 
-- Write a query that displays the surnames and salaries of employees who have jobs and their job titles. To this list, add 
-- the employees who do not have jobs and the jobs for which there are no employees who have these jobs. 