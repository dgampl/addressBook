package com.neatcode.addressBook.file;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.neatcode.addressBook.exception.InvalidInputFileException;
import com.neatcode.addressBook.pojo.Person;

public class InputFileParserTest {
	
	private InputFileParser parser;
	
	@Before
	public void setUp() {
		parser = new InputFileParser();
	}
	
	@Test
	public void throwsExceptionIfCantReadFile() {
		boolean thrown = false;
		try {
			parser.parseInputFile("src/test/resources/nonExistentFile.txt");
		} catch (InvalidInputFileException e) {
			thrown = true;
		}
		if (!thrown) {
			Assert.fail("Exception expected, but wasn't thrown.");
		}
	}
	
	@Test
	public void throwsExceptionIfEmptyFile() {
		boolean thrown = false;
		try {
			parser.parseInputFile("src/test/resources/emptyFile.txt");
		} catch (InvalidInputFileException e) {
			thrown = true;
		}
		if (!thrown) {
			Assert.fail("Exception expected, but wasn't thrown.");
		}
	}
	
	@Test
	public void throwsExceptionIfALineDoesntContainThreeTokens() {
		boolean thrown = false;
		try {
			parser.parseInputFile("src/test/resources/twoTokenFile.txt");
		} catch (InvalidInputFileException e) {
			thrown = true;
		}
		if (!thrown) {
			Assert.fail("Exception expected, but wasn't thrown.");
		}
	}
	
	@Test
	public void blankNameThrowsException() {
		boolean thrown = false;
		try {
			parser.parseInputFile("src/test/resources/blankName.txt");
		} catch (InvalidInputFileException e) {
			thrown = true;
		}
		if (!thrown) {
			Assert.fail("Exception expected, but wasn't thrown.");
		}
	}
	
	@Test
	public void invalidGenderThrowsException() {
		boolean thrown = false;
		try {
			parser.parseInputFile("src/test/resources/invalidGender.txt");
		} catch (InvalidInputFileException e) {
			thrown = true;
		}
		if (!thrown) {
			Assert.fail("Exception expected, but wasn't thrown.");
		}
	}
	
	@Test
	public void invalidDOBThrowsException() {
		boolean thrown = false;
		try {
			parser.parseInputFile("src/test/resources/invalidDOB.txt");
		} catch (InvalidInputFileException e) {
			thrown = true;
		}
		if (!thrown) {
			Assert.fail("Exception expected, but wasn't thrown.");
		}
	}
	
	@Test
	public void validInputFileShouldReturnExpectedResult() {
		ArrayList<Person> result = null;
		try {
			result = parser.parseInputFile("src/test/resources/validFile.txt");
		} catch (InvalidInputFileException e) {
			Assert.fail("No exception expected!");
		}
		assertNotNull(result);
		assertEquals(2, result.size());
		
		Person person1 = result.get(0);
		assertNotNull(person1);
		assertEquals("Bill McKnight", person1.getName());
		assertEquals('M', person1.getGender());
		Date dob1 = person1.getDob();
		assertNotNull(dob1);
		assertEquals(227318400000L, dob1.getTime());
		
		Person person2 = result.get(1);
		assertNotNull(person2);
		assertEquals("Gemma Lane", person2.getName());
		assertEquals('F', person2.getGender());
		Date dob2 = person2.getDob();
		assertNotNull(dob2);
		assertEquals(690595200000L, dob2.getTime());
		
	}

}
