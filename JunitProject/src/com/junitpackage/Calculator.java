package com.junitpackage;

public class Calculator {

	public int add(int a, int b) {
		return a + b;

	}

	public int multi(int a, int b) {

		return a * b;
	}

	public void display() {

		System.out.println("hello world");
	}

	public void div(int a, int b) {

		System.out.println(a/ b);
	}

	public static void main(String[] args) {

		Calculator cal = new Calculator();

		System.out.println(cal.add(2, 4));
		cal.display();

	}

}
