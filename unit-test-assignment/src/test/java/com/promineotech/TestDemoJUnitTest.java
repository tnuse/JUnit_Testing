package com.promineotech;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	// Parameterized Test for addPositive method TestDemo class
	// Method to set the parameters from values set in the argumentsForAddPositive Stream method
	// using an if/else loop to either complete the equation or an exception should be thrown.
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	
	
	// Stream method to add values for int a and int b, int expected (sum of a and b), and set the expectException boolean value 
	// (false if there is no exception, true if there is) in addPositive method and confirm the sum of the equation.
	static Stream<Arguments> argumentsForAddPositive() {
		return (Stream.of(
				arguments(1, 2, 3, false),
				arguments(0, 0, 0, true), 
				arguments(-1, 2, 1, true)));
		
	}
	
	// Test for addPositive method in TestDemo class
	// add values for int a and int b in addPositive method and confirm the sum of the equation. 
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(10, 15)).isEqualTo(25);
		assertThat(testDemo.addPositive(6, 11)).isEqualTo(17);
		
	}

	
	
	
	
	// Parameterized Test for firstNameAndLastNameConvertToFullName method TestDemo class
	// Method to set the values provided in the argumentsForFirstNameAndLastNameConvertToFullName Stream method
	// using 2 for loops with if/then statements to confirm all letters in the firstName and lastName Strings are letters (Testing for
	// numbers, special characters, or spaces), then returning concatenated strings as a full name
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForFirstNameAndLastNameConcatenateToFullName")
	void assertThatFirstNameAndLastNameConvertToFullName(String firstName, String lastName, String expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.firstNameAndLastNameConcatenateToFullName(firstName, lastName)).isEqualTo(expected);
			
		} else {
			assertThatThrownBy(() -> testDemo.firstNameAndLastNameConcatenateToFullName(firstName, lastName)).isInstanceOfAny(IllegalArgumentException.class);
		}
	}
	
	
	// Stream method to add values for String firstName, and String lastName, String expected (fullName as concatenated firstName + " " + lastName)
	// and set the expectException boolean value (false if there is no exception, true if there is) 
	// in firstAndLastNameConvertToFullName method and confirm the return is fullName as concatenated firstName + " " + lastName or exception
	// is thrown.
	static Stream<Arguments> argumentsForFirstNameAndLastNameConcatenateToFullName() {
		return (Stream.of(
				arguments("John", "Smith", "John Smith", false),
				arguments("Bob", "J3nkins", "Bob J3nkins", true),
				arguments("J@ck", "Smith", "J@ck Smith", true),
				arguments("John ", "Jones", "John  Jones", true),
				arguments("Sally", "Jones", "Sally Jones", false)				
				));
	}
	
	
	
	// Test for firstNameAndLastNameConvertToFullName method in TestDemo class
	// add values for String firstName and String lastName in firstNameAndLastNameConvertToFullName method and confirm 
	// the fullName is returned. Also tests that an IllegalArgumentException is thrown (using the assertThrows method) if any characters 
	// are not letters (Testing for numbers, special characters, or spaces) in the firstName or lastName String
	@Test
	void assertThatFirstNameAndLastNameConvertToFullNameCorrectly() {
		assertThat(testDemo.firstNameAndLastNameConcatenateToFullName("John", "Smith")).isEqualTo("John Smith");
		assertThat(testDemo.firstNameAndLastNameConcatenateToFullName("Sally", "Jones")).isEqualTo("Sally Jones");
		
		assertThrows(IllegalArgumentException.class, () -> testDemo.firstNameAndLastNameConcatenateToFullName("Bob", "J3nkins"));
		assertThrows(IllegalArgumentException.class, () -> testDemo.firstNameAndLastNameConcatenateToFullName("J@ck", "Smith"));
		assertThrows(IllegalArgumentException.class, () -> testDemo.firstNameAndLastNameConcatenateToFullName("John ", "Jones"));
	}
	
	
	
	
	
	// Test for randomNumberSquared method in TestDemo class
	// provides int value and expected return value to confirm method is working correctly.
	@Test
	void assertThatNumberSquaredIsCorrect () {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int numSquared = mockDemo.randomNumberSquared();
		assertThat(numSquared).isEqualTo(25);
		
	}
	
	
}
