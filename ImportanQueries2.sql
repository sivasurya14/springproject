select * from emolyeedetails  left join students  on emolyeedetails.id=students.emp_id order by emolyeedetails.id;
select count(s.emp_id) , e.name from emolyeedetails e join students s on e.id=s.emp_id group by s.emp_id;
select count(s.emp_id) as count , e.name from emolyeedetails e join students s on e.id=s.emp_id  group by s.emp_id;