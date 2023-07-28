select * from  employe.emolyeedetails;
select * from emolyeedetails where role ="admin";
select max(salary) salary , name from emolyeedetails;
select name,salary from emolyeedetails  where salary=(select max(salary) from emolyeedetails);
select  min(salary) as salary,name from emolyeedetails;
select count(role) as adminCount from emolyeedetails where role ="admin";
select * from emolyeedetails where salary >10000 and salary <50000;
select * from emolyeedetails where name like "p%"; 
select * from emolyeedetails where name like "-r%"; 
select * from emolyeedetails where salary <50000 and name like "%i";
select * from emolyeedetails  where salary <50000 order by salary ;
select count(role), role from emolyeedetails group by role;
select  avg(salary) as salary from emolyeedetails;
select * from emolyeedetails where salary=(select max(salary) from emolyeedetails);
select * from emolyeedetails where length(name)<7;
select * from emolyeedetails order by salary desc limit 1;
select * from emolyeedetails order by salary desc limit 1,1;
select * from emolyeedetails order by salary desc limit 2,1;
select * from emolyeedetails order by salary desc limit 3,3;
select * from emolyeedetails where id= (select  managerid from emolyeedetails where name="nishanthi");
select  distinct salary ,name from emolyeedetails;
select * from students where emp_id=1;
select * from emolyeedetails join students on emolyeedetails.id=students.emp_id;
select * from students join emolyeedetails on emolyeedetails.id=students.emp_id;
select * from  students left join emolyeedetails on students.emp_id=emolyeedetails.id;
select * from emolyeedetails  left join students  on emolyeedetails.id=students.emp_id;




