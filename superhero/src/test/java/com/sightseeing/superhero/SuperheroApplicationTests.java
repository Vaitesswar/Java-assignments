package com.sightseeing.superhero;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SuperheroApplicationTests {
	
	@Autowired
	private DAO DAO;
	
	@Test
	public void recordNewSighting() throws IOException{
		String heroName = "batman";
		String locationName = "Swimming complex";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp date = timestamp;
		DAO.recordNewSighting(heroName, locationName, date);
    }
	
	@Test
	public void reportSuperherosParticularLocation() throws IOException{
		String heroName = "batman";
		String locationName = "Swimming complex";
		LinkedHashSet<String> nameSet = DAO.reportSuperherosParticularLocation(locationName);
		String[] nameArray = nameSet.toArray(new String[nameSet.size()]);
		assertEquals(nameArray[0],heroName);
    }

	@Test
	public void reportLocationsParticularSuperhero() throws IOException{
		String heroName = "batman";
		String locationName = "Swimming complex";
		LinkedHashSet<String> locationSet = DAO.reportLocationsParticularSuperhero(heroName);
		String[] locationArray = locationSet.toArray(new String[locationSet.size()]);
		assertEquals(locationArray[0],locationName);
    }

}
