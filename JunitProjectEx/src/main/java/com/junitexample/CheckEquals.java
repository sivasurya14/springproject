package com.junitexample;

public class CheckEquals {

	public String reversThis(String value) {
		StringBuilder val = new StringBuilder(value);
        String reversed=  val.reverse().toString();
        return reversed;
	}

	public static void main(String[] args) {
		// CheckEquals check = new CheckEquals();
		// check.reversThis("moon");
	}
}
