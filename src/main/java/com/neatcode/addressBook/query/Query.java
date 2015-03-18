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

}
