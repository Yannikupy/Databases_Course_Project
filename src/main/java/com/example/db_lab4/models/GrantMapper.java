package com.example.db_lab4.models;

import com.example.db_lab4.entities.Grant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GrantMapper implements RowMapper<Grant> {
    @Override
    public Grant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Grant grant  = new Grant();
        grant.setId(rs.getLong("id"));
        grant.setName(rs.getString("name"));
        grant.setAmount(rs.getLong("amount"));
        grant.setSectionId(rs.getLong("section_id"));
        grant.setRealisationYear(rs.getLong("realisation_year"));
        return grant;
    }
}
