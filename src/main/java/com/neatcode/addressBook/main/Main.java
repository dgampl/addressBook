package com.neatcode.addressBook.main;

import java.io.File;
import java.util.ArrayList;

import com.neatcode.addressBook.exception.InvalidInputFileException;
import com.neatcode.addressBook.file.InputFileParser;
import com.neatcode.addressBook.pojo.Person;

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
		System.out.println(fileContent.size());

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
