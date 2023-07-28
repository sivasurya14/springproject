package com.junitexample;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

public class AssertProgrames {

	@Test
	public void testEquals() {
		assertEquals(10, 10);
	}

	@Test
	public void testNull() {
		assertNull(null, null);
	}

	@Test
	public void testTrue() {
		boolean a=10>2;
		assertTrue(a);
	}
	
	@Test
	public void assertArray() {
		
		int a[]= {1,2,3,4,5};
		int b[]= {1,2,3,4,5};
	
		assertArrayEquals(a,b);
	}
	
	@Test
	public void assertFalsecheck() {
		boolean a=10<2;
		assertFalse(false);	
		}
	@Test
	
	public void assertNotSameCheck() {
		assertNotSame("siva", "bala");
	}

	@Test
	public void assertNotNullCheck() {
		assertNotNull(2);
	}
	
	@Test
	public void assertnotEqualsCheck() {
		assertNotEquals("siva", "guru");
	}
	


}
