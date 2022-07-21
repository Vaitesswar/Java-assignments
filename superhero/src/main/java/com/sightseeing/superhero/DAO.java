package com.sightseeing.superhero;

import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	@Autowired
	private final JdbcTemplate jdbc;
	
	public DAO(JdbcTemplate jdbc) { 
		 this.jdbc = jdbc;
	}
	
	public void recordNewSighting(String heroName, String locationName, Timestamp date) {
		Superhero superhero = jdbc.queryForObject("SELECT * FROM basicInfo WHERE heroName = ?", new SuperheroMapper(), heroName);
		jdbc.update("INSERT INTO sighting(heroName,locationName,timedate,organizationName) VALUES(?,?,?,?)",
				heroName,locationName,date,superhero.getOrganization());
	}
	
	public LinkedHashSet<String> reportSuperherosParticularLocation(String locationName) {
		List<Sighting> sightingList = jdbc.query("SELECT * FROM sighting WHERE locationName = ?", new SightingMapper(), locationName);
		LinkedHashSet<String> nameSet = new LinkedHashSet<String>();
		for (Sighting sighting:sightingList) {
			nameSet.add(sighting.getHeroName());
		}
		return nameSet;
	}
	
	public LinkedHashSet<String> reportLocationsParticularSuperhero(String heroName) {
		List<Sighting> sightingList = jdbc.query("SELECT * FROM sighting WHERE heroName = ?", new SightingMapper(), heroName);
		LinkedHashSet<String> locationSet = new LinkedHashSet<String>();
		for (Sighting sighting:sightingList) {
			locationSet.add(sighting.getLocationName());
		}
		return locationSet;
	}
	
	public List<Sighting> reportSightingsParticularDate(Timestamp date) {
		List<Sighting> sightingList = jdbc.query("SELECT * FROM sighting WHERE date = ?", new SightingMapper(), date);
		return sightingList;
	}
	
	public LinkedHashSet<String> reportMembersParticularOrganization(String organization) {
		List<Sighting> sightingList = jdbc.query("SELECT * FROM sighting WHERE organization = ?", new SightingMapper(), organization);
		LinkedHashSet<String> nameSet = new LinkedHashSet<String>();
		for (Sighting sighting:sightingList) {
			nameSet.add(sighting.getHeroName());
		}
		return nameSet;
	}
	
	public String reportOrganizationsParticularSuperhero(String heroName) {
		Superhero superhero = jdbc.queryForObject("SELECT * FROM basicInfo WHERE organization = ?", new SuperheroMapper(), heroName);
		return superhero.getOrganization();
	}		
	
	public boolean recordNewHero(Superhero superhero) {
		boolean valid = true;
		try {
			jdbc.update("INSERT INTO basicInfo(heroName,info,superpower,organizationName) VALUES(?,?,?,?)",
					superhero.getName(),superhero.getDescription(),superhero.getSuperpower(),superhero.getOrganization());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean editExistingHero(Superhero superhero) {
		boolean valid = true;
		try {
			jdbc.update("UPDATE basicInfo SET "
					+ "info = ?,superpower = ?,organizationName = ?"
					+ "WHERE heroName = ?",
					superhero.getDescription(),superhero.getSuperpower(),superhero.getOrganization(),superhero.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean deleteExistingHero(Superhero superhero) {
		boolean valid = true;
		try {
			jdbc.update("DELETE FROM basicInfo WHERE heroName = ?",
					superhero.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public Superhero viewExistingHero(Superhero superhero) {
		Superhero querySuperhero = new Superhero();
		try{
			querySuperhero = jdbc.queryForObject("SELECT * FROM basicInfo WHERE heroName = ?", new SuperheroMapper(), superhero.getName());
		} catch(Exception e) {
			
		};
		return querySuperhero;
	}
	
	public boolean recordNewSuperpower(Superpower superpower) {
		boolean valid = true;
		try {
			jdbc.update("INSERT INTO superpowerInfo(superpower,info) VALUES(?,?)",
					superpower.getSuperpower(),superpower.getDescription());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean editExistingSuperpower(Superpower superpower) {
		boolean valid = true;
		try {
			jdbc.update("UPDATE superpowerInfo SET "
					+ "info = ? "
					+ "WHERE superpower = ?",
					superpower.getDescription(),superpower.getSuperpower());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean deleteExistingSuperpower(Superpower superpower) {
		boolean valid = true;
		try {
			jdbc.update("DELETE FROM superpowerInfo WHERE superpower = ?",
					superpower.getSuperpower());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public Superpower viewExistingSuperpower(Superpower superpower) {
		Superpower querySuperpower = new Superpower();
		try{
			querySuperpower = jdbc.queryForObject("SELECT * FROM superpowerInfo WHERE superpower = ?", new SuperpowerMapper(), superpower.getSuperpower());
		} catch(Exception e) {
			
		};
		return querySuperpower;
	}
	
	public boolean recordNewLocation(Location location) {
		boolean valid = true;
		try {
			jdbc.update("INSERT INTO locationInfo(locationName,info,address,latitude,longitude) VALUES(?,?,?,?,?)",
					location.getName(),location.getDescription(),location.getAddress(),location.getLatitude(),location.getLongitude());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean editExistingLocation(Location location) {
		boolean valid = true;
		try {
			jdbc.update("UPDATE locationInfo SET "
					+ "info = ?,address = ?,latitude = ?,longitude = ? "
					+ "WHERE locationName = ?",
					location.getDescription(),location.getAddress(),location.getLatitude(),location.getLongitude(),location.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean deleteExistingLocation(Location location) {
		boolean valid = true;
		try {
			jdbc.update("DELETE FROM locationInfo WHERE locationName = ?",
					location.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public Location viewExistingLocation(Location location) {
		Location queryLocation = new Location();
		try{
			queryLocation = jdbc.queryForObject("SELECT * FROM locationInfo WHERE locationName = ?", new LocationMapper(), location.getName());
		} catch(Exception e) {
			
		};
		return queryLocation;
	}
	
	public boolean recordNewOrganization(Organization organization) {
		boolean valid = true;
		try {
			jdbc.update("INSERT INTO organizationInfo(organizationName,info,address) VALUES(?,?,?)",
					organization.getName(),organization.getDescription(),organization.getAddress());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean editExistingOrganization(Organization organization) {
		boolean valid = true;
		try {
			jdbc.update("UPDATE organizationInfo SET "
					+ "info = ?,address = ? "
					+ "WHERE organizationName = ?",
					organization.getDescription(),organization.getAddress(),organization.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public boolean deleteExistingOrganization(Organization organization) {
		boolean valid = true;
		try {
			jdbc.update("DELETE FROM organizationInfo WHERE organizationName = ?",
					organization.getName());
		} catch(Exception e) {
			valid = false;
		}
		return valid;
	}
	
	public Organization viewExistingOrganization(Organization organization) {
		Organization queryOrganization = new Organization();
		try{
			queryOrganization = jdbc.queryForObject("SELECT * FROM organizationInfo WHERE organizationName = ?", new OrganizationMapper(), organization.getName());
		} catch(Exception e) {
			
		};
		return queryOrganization;
	}
	
}
