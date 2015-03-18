package com.neatcode.addressBook.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import com.neatcode.addressBook.exception.InvalidInputFileException;
import com.neatcode.addressBook.pojo.Person;

public class InputFileParser {
	
	private static final String INVALID_CONTENT_MESSAGE = "Invalid content in the file provided.";

	public ArrayList<Person> parseInputFile(String fileName) throws InvalidInputFileException {
		ArrayList<Person> fileContent = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			if (line == null) {
				reader.close();
				throw new InvalidInputFileException("Supplied file is empty.");
			}
			while (line != null) {
				Person person = parseLine(line);
				fileContent.add(person);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new InvalidInputFileException(e.getMessage());
		} catch (IOException e) {
			throw new InvalidInputFileException(e.getMessage());
		}
		return fileContent;
	}

	private Person parseLine(String line) throws InvalidInputFileException {
		Person person = new Person();
		StringTokenizer tokenizer = new StringTokenizer(line, ",");
		if (tokenizer.countTokens() != 3) {
			throw new InvalidInputFileException(INVALID_CONTENT_MESSAGE);
		}
		
		String name = tokenizer.nextToken().trim();
		if (name.length() == 0) {
			throw new InvalidInputFileException(INVALID_CONTENT_MESSAGE);
		}
		person.setName(name);
		
		String gender = tokenizer.nextToken().trim();
		if ("Male".equals(gender)) {
			person.setGender('M');
		} else if ("Female".equals(gender)) {
			person.setGender('F');
		} else {
			throw new InvalidInputFileException(INVALID_CONTENT_MESSAGE);
		}
		
		String dobStr = tokenizer.nextToken().trim();
		Date dob = null;
		try {
			dob = new SimpleDateFormat("dd/MM/yy").parse(dobStr);
		} catch (ParseException e) {
			throw new InvalidInputFileException(INVALID_CONTENT_MESSAGE);
		}
		
		person.setDob(dob);
		return person;
	}
}
