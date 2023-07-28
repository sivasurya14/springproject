package com.example.employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeService {

	@Autowired
	EmployeDAO empDao;

//	public String addEmploye(EmployeEntity e) throws ExceptionHandler, Exception {	
//		
//		if(e.getAge()<18) {
//			throw new ExceptionHandler("Age Cannot be lesser than 18");
//		}
//		else {	
//			return empDao.addEmploye(e);
//		}
//	}
	public String addEmploye(EmployeEntity e) throws ExceptionHandler, Exception {
		try {
			if (e.getAge() < 18) {
				throw new ExceptionHandler("age something");
			} else {
				return empDao.addEmploye(e);
			}
		} catch (ExceptionHandler eh) {
			return "Age Cannot be lesser than 18 ";
		}
	}

	public String addEmployees(List<EmployeEntity> e) {

		return empDao.addEmployees(e);
	}

	public EmployeEntity findById(int id) {
		return empDao.findById(id);

	}

	public List<EmployeEntity> findAllEmp() {

		return empDao.findAllEmp();
	}

	public String deleteId(int id) {
		return empDao.deleteId(id);
	}

	public List<EmployeEntity> getBySalary(int id) {
		List<EmployeEntity> list = empDao.findAllEmp();
		List<EmployeEntity> getSalary = list.stream().filter(x -> x.getSalary() > id).collect(Collectors.toList());
		return getSalary;
	}

	public EmployeEntity getMaxSalary() {
		return empDao.findAllEmp().stream().max(Comparator.comparingInt(EmployeEntity::getSalary)).get();
	}

	public List<EmployeEntity> getEmployeeByGender(String gender) {
		return empDao.findAllEmp().stream().filter(x -> x.getGender().equalsIgnoreCase(gender))
				.collect(Collectors.toList());
	}

	public List<EmployeEntity> getAgeBetween(int age1, int age2) {
		return empDao.findAllEmp().stream().filter(x -> x.getAge() >= age1 && x.getAge() <= age2)
				.collect(Collectors.toList());
	}

	public List<String> getNamebySalary(int salary) throws ExceptionHandler, Exception  {
		List<String> list= empDao.findAllEmp().stream().filter(x -> x.getSalary() == salary).map(x -> x.getName()).toList();		
		return list;
	}

	public List<EmployeEntity> getByTwoSalary(int salary1, int salary2) {
		return empDao.getByTwosalary(salary1, salary2);
	}

	public List<EmployeEntity> getByGender(String gender) throws ExceptionHandler, Exception {
		if(empDao.getByGender(gender).isEmpty()) {	
			throw new ExceptionHandler("Gender is not aavailable...");
		}
		else {
		return empDao.getByGender(gender);
		}
	}

	public EmployeEntity getMaxSalary2() throws ExceptionHandler , Exception{
		
            if(empDao.getMax()==null) {
            	throw new ExceptionHandler("There is no data ");
            }
            else {
		return empDao.getMax();
	}
	}
	public List<EmployeEntity> getByName(String name) throws NameNoFoundException, Exception {
		List<EmployeEntity> list ;
		if (empDao.getByName(name).isEmpty()) {
			throw new NameNoFoundException("Name is not in Database....!");
		} else {
			list=empDao.getByName(name);
		}
         return list;
	}
	
}
