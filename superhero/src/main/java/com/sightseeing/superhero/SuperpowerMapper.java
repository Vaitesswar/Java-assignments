package com.sightseeing.superhero;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public final class SuperpowerMapper implements RowMapper<Superpower>{
	
	public Superpower mapRow(ResultSet rs, int index) throws SQLException {
		Superpower superpower = new Superpower();
		superpower.setSuperpower(rs.getString("superpower"));
		superpower.setDescription(rs.getString("info"));

        return superpower;
    }
}