package com.sightseeing.superhero;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public final class OrganizationMapper implements RowMapper<Organization>{
	
	public Organization mapRow(ResultSet rs, int index) throws SQLException {
		Organization organization = new Organization();
		organization.setName(rs.getString("organizationName"));
		organization.setDescription(rs.getString("info"));
		organization.setAddress(rs.getString("address"));

        return organization;
    }
}
