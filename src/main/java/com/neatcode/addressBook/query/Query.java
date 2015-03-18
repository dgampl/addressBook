package com.neatcode.addressBook.query;

import java.util.ArrayList;

import com.neatcode.addressBook.pojo.Person;

public class Query {

	public int countMales(ArrayList<Person> fileContent) {
		int malesCount = 0;
		for (Person person : fileContent) {
			if ('M' == person.getGender()) {
				malesCount++;
			}
		}
		return malesCount;
	}

	public String getOldestPerson(ArrayList<Person> fileContent) {
		String oldestPerson = null;
		long oldestDob = 0L;
		for (Person person : fileContent) {
			String name = person.getName();
			long dob = person.getDob().getTime();
			if (oldestDob == 0L) {
				oldestDob = dob;
				oldestPerson = name;
			} else {
				if (dob < oldestDob) {
					oldestPerson = name;
					oldestDob = dob; 
				}
			}
		}
		return oldestPerson;
	}

}
