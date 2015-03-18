package com.neatcode.addressBook.main;

import java.util.ArrayList;

import com.neatcode.addressBook.exception.InvalidInputFileException;
import com.neatcode.addressBook.file.InputFileParser;
import com.neatcode.addressBook.pojo.Person;

public class Main {

	public static void main(String[] args) {
		InputFileParser parser = new InputFileParser();
		ArrayList<Person> fileContent = null;
		try {
			fileContent = parser.parseInputFile("../inbox/AddressBook");
		} catch (InvalidInputFileException e) {
			System.out.println(e.getMessage());
			System.out.println("Invalid input file. Exiting...");
			System.exit(-1);
		}
		System.out.println(fileContent.size());

	}

}
