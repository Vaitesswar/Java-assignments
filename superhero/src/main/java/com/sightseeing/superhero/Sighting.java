package com.sightseeing.superhero;

import java.sql.Date;
import java.util.Objects;

public class Sighting {
	
	private String heroName;
	private String locationName;
	private Date date;
	
	public Sighting(){};
	
	public Sighting(String heroName, String locationName, Date date, String organizationName) {
		super();
		this.heroName = heroName;
		this.locationName = locationName;
		this.date = date;
	}
	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, heroName, locationName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sighting other = (Sighting) obj;
		return Objects.equals(date, other.date) && Objects.equals(heroName, other.heroName)
				&& Objects.equals(locationName, other.locationName);
	}
	@Override
	public String toString() {
		return "Sighting [heroName=" + heroName + ", locationName=" + locationName + ", date=" + date
				+ "]";
	}

}
