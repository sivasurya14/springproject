package com.employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("session")
@Component
public class Employee {

	private String name;

	public Employee() {

		System.out.println("Bean is created..");
	}

	public String getName() {
		return name;
	}

	@Value("siva")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

}
