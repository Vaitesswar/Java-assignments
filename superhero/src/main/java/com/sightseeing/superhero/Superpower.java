package com.sightseeing.superhero;

import java.util.Objects;

public class Superpower {
	
	private String superpower;
	private String description;
	
	public Superpower(){};
	
	public Superpower(String superpower, String description) {
		super();
		this.superpower = superpower;
		this.description = description;
	}
	public String getSuperpower() {
		return superpower;
	}
	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, superpower);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Superpower other = (Superpower) obj;
		return Objects.equals(description, other.description) && Objects.equals(superpower, other.superpower);
	}
	@Override
	public String toString() {
		return "Superpower [superpower=" + superpower + ", description=" + description + "]";
	}
}
