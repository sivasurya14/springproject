package com.example.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeRepository extends JpaRepository<EmployeEntity, Integer>{
	
	
	@Query(value="select * from employee_data where salary>=? and salary <=?", nativeQuery =true )
	public List<EmployeEntity> getByTwoSalary (int salary , int salary2);

	
	@Query(value="select * from employee_data where gender =? ", nativeQuery = true)
	public List<EmployeEntity> getByGender(String name);
	
	@Query(value="select max(salary) from employee_data ", nativeQuery = true)
	public EmployeEntity  getMaxSalary2();
	
	@Query(value="Select * from employee_data where name =?", nativeQuery = true)
	public List<EmployeEntity> getByName(String name );
}
