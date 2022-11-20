package com.example.db_lab4.models;

import com.example.db_lab4.entities.ScientificDirection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectionMapper implements RowMapper<ScientificDirection> {
    @Override
    public ScientificDirection mapRow(ResultSet rs, int rowNum) throws SQLException {
        ScientificDirection scientificDirection  = new ScientificDirection();
        scientificDirection.setCipher(rs.getLong("cipher"));
        scientificDirection.setSectionTitle(rs.getString("section_title"));
        return scientificDirection;
    }
}
