package com.sightseeing.superhero;

import java.util.Objects;

public class Organization {
	
	private String name;
	private String description;
	private String address;
	
	public Organization(){};
	
	public Organization(String name, String description, String address, String member) {
		super();
		this.name = name;
		this.description = description;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, description, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization other = (Organization) obj;
		return Objects.equals(address, other.address) && Objects.equals(description, other.description)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Organization [name=" + name + ", description=" + description + ", address=" + address + "]";
	}

}
