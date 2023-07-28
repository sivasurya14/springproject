package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class DemoController {

	@GetMapping("/get")
	public String getMessage() {
		return "Hellow World ";

	}

	@GetMapping("/getName")
	public String getName() {
		return "Hello sivasuriyan";
	}

	@GetMapping("/add/{no1}/{no2}")
	public int addNumber(@PathVariable int no1, @PathVariable int no2) {
		return no1 + no2;
	}

	@GetMapping("/getEligibility/getAge/{age}")

	public String verifyAge(@PathVariable int age) {

		if (age <= 18 && age >= 50) {

			return "you are not eligible to vote ";
		} else
			return "you are Eligiblen to vote !";
	}

	@GetMapping("/getNumbers/{no}")
	public List<Integer> getNumbers(@PathVariable int no) {
		List<Integer> li = new ArrayList<>();
		for (int i = 0; i <= no; i++) {
			li.add(i);
		}
		return li;
	}

	@GetMapping("/SquareTheNumbers/{no}/{no1}")

	public int squareTheNUmbers(@PathVariable int no, @PathVariable int no1) {

		return no * no;
	}

	@GetMapping("/printEvenNo/{no}")

	public List<Integer> getEven(@PathVariable int no) {

		List<Integer> li = new ArrayList<>();
		for (int i = 0; i <= no; i++) {

			li.add(i * i);
		}
		return li;
	}

	@GetMapping("/getFactorial/{a}")
	public int getFactorial(@PathVariable int a) {
		int temp = 1;
		for (int i = 1; i <= a; i++) {
			temp = temp * i;
		}
		return temp;
	}

	@GetMapping("/addNumbers")

	public int add_Numbers(@PathParam("no1") int no1, @PathParam("no2") int no2) {

		return no1 + no2;

	}

	@GetMapping("/check")

	public String log_In(@PathParam("username") String username, @PathParam("password") String password) {

		if (username.equals("siva") && password.equals("siva12")) {

			return " welcome to java ";
		} else {
			return "invalid login";
		}
	}

	@GetMapping("/multi")

	public int multi_Numbers(@PathParam("no1") int no1, @PathParam("no2") int no2) {

		return no1 + no2;

	}

	@GetMapping("/empdetails")

	public EmpoloyeEntity getEMployee(@RequestBody EmpoloyeEntity emp) {

		emp.setName("Mr." + emp.getName());

		return emp;
	}

	@GetMapping("/listOfEmp")

	public List<EmpoloyeEntity> getEmpList(@RequestBody List<EmpoloyeEntity> list) {

		return list;

	}

	@GetMapping("/listOfMaleEmploye")
	public List<EmpoloyeEntity> getMaleEmpList(@RequestBody List<EmpoloyeEntity> list) {

		return list.stream().filter(x -> x.getGender().equalsIgnoreCase("male")).collect(Collectors.toList());
	}

	@GetMapping("/listOfFeMaleEmploye")
	public List<EmpoloyeEntity> getFeMaleEmpList(@RequestBody List<EmpoloyeEntity> list) {

		return list.stream().filter(x -> x.getGender().equalsIgnoreCase("female")).collect(Collectors.toList());
	}

	@GetMapping("/maxSalary")
	public EmpoloyeEntity getMaxSalary(@RequestBody List<EmpoloyeEntity> list) {

		EmpoloyeEntity emp = list.stream().max(Comparator.comparingInt(EmpoloyeEntity::getSalary)).get();

		return emp;
	}

	@GetMapping("/minSalary")
	public EmpoloyeEntity getMinSalary(@RequestBody List<EmpoloyeEntity> list) {

		EmpoloyeEntity emp = list.stream().min(Comparator.comparingInt(EmpoloyeEntity::getSalary)).get();

		return emp;
	}

//	@GetMapping("/discount")
//	public List<EmpoloyeEntity> giveDiscount(@RequestBody List<EmpoloyeEntity> list) {
//		
//		return list.stream().filter(x->x.getAge()<=45&&x.getAge()>=55)

	@GetMapping("/sortByAge")
	public List<EmpoloyeEntity> sortByAge(@RequestBody List<EmpoloyeEntity> list) {

		return list.stream().sorted(Comparator.comparingInt(EmpoloyeEntity::getAge)).collect(Collectors.toList());

	}

	@GetMapping("/sortByAgemax")
	public List<EmpoloyeEntity> sortByAgeRevers(@RequestBody List<EmpoloyeEntity> list) {

		return list.stream().sorted(Comparator.comparingInt(EmpoloyeEntity::getAge).reversed())
				.collect(Collectors.toList());
	}

	@GetMapping("/getDiscount")

	public List<EmpoloyeEntity> getDiscount(@RequestBody List<EmpoloyeEntity> list) {

		list.stream().filter(x -> x.getAge() > 45).forEach((y) -> {

			int salary = y.getSalary();
			int incrementsalary = y.getSalary() * 5 / 100;
			y.setSalary(incrementsalary + salary);
		});
		return list;
	}
	@GetMapping("/addTwoNumbers")
	public int addTwoNumbers(@RequestParam("no1") int no1, @RequestParam("no2") int no2) {
		return no1 + no2;
	}    
}
