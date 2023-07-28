package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeScopeofBeanApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeScopeofBeanApplication.class, args);
	}

	@Autowired
	ApplicationContext con;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");
		Employee e1 =con.getBean(Employee.class);
		e1.setName("guru");
		System.out.println(e1);	
		Employee e2 = con.getBean(Employee.class);
		System.out.println(e2);
		Employee e3= con.getBean(Employee.class);
		System.out.println(e3);
		

	}

}
