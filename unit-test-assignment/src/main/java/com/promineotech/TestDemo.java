package com.promineotech;

import java.util.Random;

public class TestDemo {

	
	// Method to return the sum of 2 positive numbers, with check to confirm both numbers are greater than 0
	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		} else {
			return a+b;
		}
	}
	
	
	
	// Create own method, firstNameAndLastNameConvertToFullName
	// Method to take 2 Strings (firstName and lastName), using 2 for loops (one for each String) with if/else statements
	// to confirm each String only contains letters using the Character.isLetter method.  If a character in the string is not
	// a letter, it will throw an IllegalArgumentException, with a message that the name entered is not valid.  if there are no
	// exceptions, the method will return a concatenated string of firstName/space/lastName as the full name.
	public String firstNameAndLastNameConcatenateToFullName(String firstName, String lastName) {
		for (int i = 0; i < firstName.length(); i++) {	
			if (!Character.isLetter(firstName.charAt(i))) {
				throw new IllegalArgumentException("The first name entered is not valid");
			} 
		}
		
		for (int i = 0; i < lastName.length(); i++) {			
			if (!Character.isLetter(lastName.charAt(i))) {
				throw new IllegalArgumentException("The last name entered is not valid");
			} 
		}
		
		return firstName + " " + lastName;
	}
	
	
	// Method to randomly generate a number between 1 and 10
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

	// Method to take randomly generated number from getRandomInt method
	// and return the value of that number squared
	public int randomNumberSquared() {
		int i = getRandomInt(); 
		return i*i;
		
		
		
		
	}

}
