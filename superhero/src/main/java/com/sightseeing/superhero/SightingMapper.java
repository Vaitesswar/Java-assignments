package com.sightseeing.superhero;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public final class SightingMapper implements RowMapper<Sighting>{
	
	public Sighting mapRow(ResultSet rs, int index) throws SQLException {
		Sighting sighting = new Sighting();
		sighting.setHeroName(rs.getString("heroName"));
		sighting.setLocationName(rs.getString("locationName"));
		sighting.setDate(rs.getDate("timedate"));

        return sighting;
    }
}