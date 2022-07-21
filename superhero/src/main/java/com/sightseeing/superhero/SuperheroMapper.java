package com.sightseeing.superhero;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public final class SuperheroMapper implements RowMapper<Superhero>{
	
	public Superhero mapRow(ResultSet rs, int index) throws SQLException {
		Superhero superhero = new Superhero();
		superhero.setName(rs.getString("heroName"));
		superhero.setDescription(rs.getString("info"));
		superhero.setSuperpower(rs.getString("superpower"));
        superhero.setOrganization(rs.getString("organizationName"));

        return superhero;
    }
}
