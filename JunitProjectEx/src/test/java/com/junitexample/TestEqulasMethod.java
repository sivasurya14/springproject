package com.junitexample;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

 public class TestEqulasMethod {
	CheckEquals check = new CheckEquals();
	
	
	        @Test	
	        public void testEqualsMethod() {		
	//	String reversed=check.reversThis("moon");
		assertEquals(check.reversThis("moon"), "noom");
		
	}
	
	
}
