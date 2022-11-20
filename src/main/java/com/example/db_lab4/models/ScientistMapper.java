package com.example.db_lab4.models;

import com.example.db_lab4.entities.Scientist;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScientistMapper implements RowMapper<Scientist> {
    @Override
    public Scientist mapRow(ResultSet rs, int rowNum) throws SQLException {
        Scientist scientist  = new Scientist();
        scientist.setId(rs.getLong("id"));
        scientist.setLastName(rs.getString("last_name"));
        scientist.setFirstName(rs.getString("first_name"));
        scientist.setPatronymic(rs.getString("patronymic"));
        scientist.setBirthday(rs.getDate("birthday").toLocalDate());
        scientist.setAcademicDegree(rs.getString("academic_degree"));
        scientist.setAcademicTitle(rs.getString("academic_title"));
        return scientist;
    }
}
