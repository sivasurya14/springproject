package com.example.employee;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.websocket.server.PathParam;

@RestController
// @RequestMapping(value="/employee")
public class EmployeController {

	@Autowired
	EmployeService empService;
	

	//Using RestTemplate 
	
	RestTemplate rest = new RestTemplate();
	
	@GetMapping("/getBikeDetails")	
	public List<BikeEntity> getCarDetails() {
		ParameterizedTypeReference<List<BikeEntity>>  parameterizedTypeReference = new ParameterizedTypeReference<List<BikeEntity>>(){
			
		};
		String url="http://localhost:8080/bike/getBikeDetails";
		ResponseEntity<List<BikeEntity>> response=rest.exchange(url, HttpMethod.GET, null,parameterizedTypeReference);	
		return response.getBody();		
	}
	
	@PostMapping(value = "/saveDetails")
	public String addEmploye(@RequestBody EmployeEntity e) throws ExceptionHandler, Exception {		
		return empService.addEmploye(e);
	}
																																
	@PostMapping("/saveAll")
	public String addEmployees(@RequestBody List<EmployeEntity> e) {
		return empService.addEmployees(e);
	}

	@GetMapping("/getById/{id}")
	public EmployeEntity findById(@PathVariable int id) {
		EmployeEntity employee= empService.findById(id);
		if(employee==null)
	  throw new NoSuchElementException("id is not present ");	
		return employee;
		}
	@GetMapping("/getAllEmp")

	public ResponseEntity<List<EmployeEntity>> findAllEmp() {
	List<EmployeEntity> list=	empService.findAllEmp();		
     return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@DeleteMapping("/delete/{id}")
	
	public String deleteId(@PathVariable int id) {
		return empService.deleteId(id);
	}
	
	@GetMapping("/getBySalary/{salary}")
	public List<EmployeEntity>  getBySalary(@PathVariable int salary){
			return empService.getBySalary(salary);
	}
	
	@GetMapping("/getMaxSalary")
	public EmployeEntity getMaxSalary() {	
		return empService.getMaxSalary();
	}
	
	@GetMapping("/getByGender")	
	public List<EmployeEntity>  getByGender(@RequestParam String gender){		
		return empService.getEmployeeByGender(gender);
	}
	
	@GetMapping("/getAgeBetween")
    public List<EmployeEntity> getAgeBetween(@PathParam ("age1") int age1,@PathParam ("age2") int age2){
	 return empService.getAgeBetween(age1, age2);
		}
	
	@GetMapping("/getNameBySalary/{salary}")
	public List<String> getNameBySalary (@PathParam ("salary") int salary) throws ExceptionHandler, Exception{
		return empService.getNamebySalary(salary);
		
	}
	
	@GetMapping("/getByTwoSalary/{salary1}/{salary2}")
	public List<EmployeEntity>  getByTwoSalary(@PathVariable int salary1, @PathVariable int salary2){	
		return empService.getByTwoSalary(salary1, salary2);
	}
	
	// Get list of employees by gender using custome Query 
	
	@GetMapping("/getByGenderr")
	public List<EmployeEntity> getByGenderr(@PathParam (value="gender") String gender ) throws ExceptionHandler, Exception{
		return empService.getByGender(gender);
	}
	
	@GetMapping("/getMax2")
	public EmployeEntity getMaxSalary2() throws ExceptionHandler, Exception {
		return empService.getMaxSalary2();
	}
	
	@GetMapping("/getByname")
	public List<EmployeEntity> getByName(@PathParam (value="name")String name) throws NameNoFoundException, Exception{
		return empService.getByName(name);
	}
	
	
}