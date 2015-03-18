package com.neatcode.addressBook.query;

import java.util.ArrayList;
import java.util.Date;

import com.neatcode.addressBook.exception.NameDoesntExistException;
import com.neatcode.addressBook.pojo.Person;

public class Query {

	public int getMalesCount(ArrayList<Person> fileContent) {
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

	public long getDobDiffInDaysFor(String name1, String name2, ArrayList<Person> fileContent) throws NameDoesntExistException {
		long dobDiffInDays = 0L;
		Date dob1 = null;
		Date dob2 = null;
		for (Person person : fileContent) {
			String name = person.getName();
			if (name1.equals(name)) {
				dob1 = person.getDob();
			}
			if (name2.equals(name)) {
				dob2 = person.getDob();
			}
		}
		
		if (dob1 == null || dob2 == null) {
			throw new NameDoesntExistException();
		}
		
		long dob1Millis = dob1.getTime();
		long dob2Millis = dob2.getTime();
		long dobDiffMillis = dob1Millis - dob2Millis;
		
		dobDiffInDays = dobDiffMillis / (1000 * 60 * 60 * 24);
		
		return dobDiffInDays;
	}
}
