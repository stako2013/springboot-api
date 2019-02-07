package com.paloit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.paloit.model.Person;
import com.paloit.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PersonService {

	public static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	private PersonRepository personRepository;

	/*
	 * Adding new person
	 */
	public void addPerson(Person person) {
		personRepository.save(person);
	}

	public int getMaxConsecutiveZeros(String personName) throws Exception {

		char[] nameCharacters = personName.toCharArray();

		logger.info("Calculating ASCII value of each character of \"" + personName + "\".");

		int sumOfASCIIValues = calculateSumOfAsciiValues(nameCharacters);

		String binaryString = Integer.toBinaryString(sumOfASCIIValues);

		logger.info("Binary of " + sumOfASCIIValues + ": " + binaryString);

		int maxConsecutiveZero = calculateMaxConsecutiveZeros(binaryString);

		return maxConsecutiveZero;
	}

	private int calculateSumOfAsciiValues(char[] nameCharacters) {

		int sum = 0;

		for (char character : nameCharacters) {
			int asciiValue = (int) character;
			logger.info(character + ": " + asciiValue);
			sum += asciiValue;
		}

		logger.info("Sum of ASCII values: " + sum);

		return sum;

	}

	private int calculateMaxConsecutiveZeros(String binaryString) {

		char[] binaryCharacters = binaryString.toCharArray();

		int countConsecutiveZero = 0;
		int tempCount = 0;

		for (char character : binaryCharacters) {

			if (character == '0') {
				tempCount++;
			} else {
				tempCount = 0;
			}

			if (tempCount > countConsecutiveZero) {
				countConsecutiveZero = tempCount;
			}

		}

		logger.info("The largest number of consecutive zeros: " + countConsecutiveZero);

		return countConsecutiveZero;
	}

}
