package com.paloit.controller;

import org.slf4j.Logger;
import java.util.HashMap;
import org.slf4j.LoggerFactory;
import com.paloit.model.Person;
import com.paloit.service.PersonService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonController {

	public static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;

	/*
	 * Adding new person
	 */
	@RequestMapping(value = "/persons", method = RequestMethod.POST)
	public HashMap<String, Object> addPerson(@RequestBody Person person) throws Exception {

		logger.info("Adding Person ....");
		
		String personName = person.getName();
		String[] fullName = personName.split(" ");
		
		String fristName = fullName[0];
		String lastName = fullName[1];
		
		person.setFirstName(fristName);
		person.setLastName(lastName);
		
		personService.addPerson(person);

		int maxConsecutiveZeros = 0;

		maxConsecutiveZeros = personService.getMaxConsecutiveZeros(personName);

		HashMap<String, Object> map = new HashMap<>();
		map.put("status", "OK");
		map.put("maxCountConsecutiveZero", maxConsecutiveZeros);

		return map;
	}

}