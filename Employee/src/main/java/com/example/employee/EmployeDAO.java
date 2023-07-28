package com.example.employee;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeDAO {

	@Autowired
	EmployeRepository emp;

	public String addEmploye(EmployeEntity e) throws ExceptionHandler, Exception {
		emp.save(e);
		return "data saved successfully ";

	}
	public String addEmployees(List<EmployeEntity> e) {
		emp.saveAll(e);
		return "data saved successfully";
	}

	public EmployeEntity findById(int id ) {		
		return emp.findById(id).get();
	}
	
	public List<EmployeEntity> findAllEmp(){
		
		List<EmployeEntity> list = emp.findAll();
		
		return list;
	}
	
	public String deleteId(int id ) {		
		emp.deleteById(id);		
		return "deleted data successfully";
	}
	
	public List<EmployeEntity> getByTwosalary(int salary1 , int salary2){		
		return emp.getByTwoSalary(salary1, salary2);
	}
	
	public List<EmployeEntity> getByGender(String gender){	
		return emp.getByGender(gender);
	}
	public EmployeEntity getMax() {		
		return emp.getMaxSalary2();
	}
	
	public List<EmployeEntity>   getByName(String name)throws NameNoFoundException, Exception{		
		return emp.getByName(name);
	}
	
	}


