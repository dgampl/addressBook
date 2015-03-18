package com.neatcode.addressBook.query;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.neatcode.addressBook.pojo.Person;

public class QueryTest {
	
	private Query query;
	
	@Before
	public void setUp() {
		query = new Query();
	}
	
	@Test
	public void returnsCorrectAmountOfMales() {
		ArrayList<Person> fileContent = new ArrayList<>();
		Person person1 = new Person();
		person1.setGender('M');
		fileContent.add(person1);
		Person person2 = new Person();
		person2.setGender('F');
		fileContent.add(person2);
		Person person3 = new Person();
		person3.setGender('M');
		fileContent.add(person3);
		
		int malesCount = query.countMales(fileContent);
		
		assertEquals(2, malesCount);
	}
	
	@Test
	public void returnsOldestPerson() {
		Calendar calendar = Calendar.getInstance();
		ArrayList<Person> fileContent = new ArrayList<>();
		Person person1 = new Person();
		person1.setName("Daniel");
		Date dob1 = calendar.getTime();
		person1.setDob(dob1);
		fileContent.add(person1);
		Person person2 = new Person();
		person2.setName("James");
		calendar.add(Calendar.YEAR, 1);
		Date dob2 = calendar.getTime();
		person2.setDob(dob2);
		fileContent.add(person2);
		Person person3 = new Person();
		person3.setName("Peter");
		calendar.roll(Calendar.YEAR, -2);
		Date dob3 = calendar.getTime();
		person3.setDob(dob3);
		fileContent.add(person3);
		
		String oldestPerson = query.getOldestPerson(fileContent);
		
		assertEquals("Peter", oldestPerson);
	}

}
