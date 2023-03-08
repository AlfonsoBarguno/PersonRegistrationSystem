package com.Bargunyo.PersonDB;

import com.Bargunyo.PersonDB.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PersonDbApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void canParseCSV(){

		String csvLine = "Alfonso, Barguñó, caballerotito@yahoo.es, 9/3/1980,50000";

		Person person = Person.parse(csvLine);

		assertTrue(person.getName().endsWith("onso"));

		//assertThat(person.getDob().isEqual(LocalDate.of(1980,3,9)));
	}

}
