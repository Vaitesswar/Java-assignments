package com.sightseeing.superhero;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public final class LocationMapper implements RowMapper<Location>{
	
	public Location mapRow(ResultSet rs, int index) throws SQLException {
		Location location = new Location();
		location.setName(rs.getString("locationName"));
		location.setDescription(rs.getString("info"));
		location.setAddress(rs.getString("address"));
		location.setLatitude(rs.getBigDecimal("latitude"));
		location.setLongitude(rs.getBigDecimal("longitude"));

        return location;
    }
}
