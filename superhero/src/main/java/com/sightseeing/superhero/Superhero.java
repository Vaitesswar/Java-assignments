package com.sightseeing.superhero;

import java.util.Objects;

public class Superhero {
	
	private String name;
	private String description;
	private String superpower;
	private String organization;
	
	public Superhero(){};
	
	public Superhero(String name, String description, String superpower, String organization) {
		super();
		this.name = name;
		this.description = description;
		this.superpower = superpower;
		this.organization = organization;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSuperpower() {
		return superpower;
	}
	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, name, organization, superpower);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Superhero other = (Superhero) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(organization, other.organization) && Objects.equals(superpower, other.superpower);
	}
	@Override
	public String toString() {
		return "Model [name=" + name + ", description=" + description + ", superpower=" + superpower + ", organization="
				+ organization + "]";
	}
}
