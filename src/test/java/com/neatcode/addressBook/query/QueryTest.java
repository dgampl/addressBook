package com.neatcode.addressBook.query;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

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

}
