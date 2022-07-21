package com.sightseeing.superhero;

import java.math.BigDecimal;
import java.util.Objects;

public class Location {
	
	private String name;
	private String description;
	private String address;
	private BigDecimal latitude;
	private BigDecimal longitude;
	
	public Location(){};
	
	public Location(String name, String description, String address, BigDecimal latitude, BigDecimal longitude) {
		super();
		this.name = name;
		this.description = description;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, description, latitude, longitude, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(address, other.address) && Objects.equals(description, other.description)
				&& Objects.equals(latitude, other.latitude) && Objects.equals(longitude, other.longitude)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Location [name=" + name + ", description=" + description + ", address=" + address + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}
}
