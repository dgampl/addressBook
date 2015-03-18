package com.neatcode.addressBook.main;

import java.io.File;
import java.util.ArrayList;

import com.neatcode.addressBook.exception.InvalidInputFileException;
import com.neatcode.addressBook.exception.NameDoesntExistException;
import com.neatcode.addressBook.file.InputFileParser;
import com.neatcode.addressBook.pojo.Person;
import com.neatcode.addressBook.query.Query;

public class Main {

	public static void main(String[] args) {
		checkParams(args);
		InputFileParser parser = new InputFileParser();
		ArrayList<Person> fileContent = null;
		try {
			fileContent = parser.parseInputFile(args[0]);
		} catch (InvalidInputFileException e) {
			System.out.println(e.getMessage());
			System.out.println("Invalid input file. Exiting...");
			System.exit(-1);
		}
		
		Query query = new Query();
		int malesCount = query.getMalesCount(fileContent);
		System.out.println("Amount of males in the AddressBook is: " + malesCount);
		
		String oldestPerson = query.getOldestPerson(fileContent);
		System.out.println("The oldest person in the AddressBook is: " + oldestPerson);
		
		String name1 = "Bill McKnight";
		String name2 = "Paul Robinson";
		long dobDiffInDays = 0L;
		try {
			dobDiffInDays = query.getDobDiffInDaysFor(name1, name2, fileContent);
		} catch (NameDoesntExistException e) {
			System.out.println("Unable to determine who is older. At least one of the names doesn't exist in the file provided: " + name1 + ", " + name2);
			System.exit(-4);
		}
		if (dobDiffInDays == 0L) {
			System.out.println(name1 + " and " + name2 + " are equally old.");
		} else if (dobDiffInDays < 0) {
			System.out.println(name1 + " is " + Math.abs(dobDiffInDays) + " days older than " + name2 + ".");
		} else {
			System.out.println(name1 + " is " + dobDiffInDays + " days younger than " + name2 + ".");
		}
	}

	private static void checkParams(String[] args) {
		if (args.length != 1) {
			System.out.println("Invalid number of arguments. Expected 1 argument.");
			System.exit(-2);
		}
		
		File inputFile = new File(args[0]);
		if (!inputFile.canRead()) {
			System.out.println("Can't read from the input file. Please check the first argument.");
			System.exit(-3);
		}
	}
}
