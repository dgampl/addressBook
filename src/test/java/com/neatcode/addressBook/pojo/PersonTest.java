package com.neatcode.addressBook.pojo;


import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	
	private Person person;
	
	@Before
	public void setUp() {
		person = new Person();
	}
	
	@Test
	public void returnsCorrectName() {
		person.setName("Daniel");
		assertEquals("Daniel", person.getName());
	}
	
	@Test
	public void returnsCorrectGender() {
		person.setGender('M');
		assertEquals('M', person.getGender());
	}
	
	@Test
	public void returnsCorrectDob() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		person.setDob(date);
		assertEquals(date, person.getDob());
	}
}
