package com.junitexample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
		
		CalculatorEx cal = new CalculatorEx();
			
			@Before
			public void display() {
				System.out.println("Program started..");		
			}
		    @Test
		    public void displayy() {
		    	cal.display();
		    }
			
			@Test
			public void addTest() {
			System.out.println(cal.add(2, 3));
				
			}
			@Test
			public void multiTest() {
				System.out.println(cal.multi(2, 3));
			}
			
			@Test
			public void divTest() {
				cal.div(100, 10);
			}
			
			@After
			public void show() {
				System.out.println("completed...");
			}
}
