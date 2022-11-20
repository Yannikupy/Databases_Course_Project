package com.example.db_lab4.dao;

import com.example.db_lab4.entities.ScientificDirection;
import com.example.db_lab4.models.DirectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScientificDirectionDAOImpl implements ScientificDirectionDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_DIRECTION = "select * from scientific_directions where cipher = ?";
    private final String SQL_DELETE_DIRECTION = "delete from scientific_directions where cipher = ?";
    private final String SQL_GET_ALL_DIRECTIONS = "select * from scientific_directions order by cipher asc";
    private final String SQL_INSERT_DIRECTION = "insert into scientific_directions(cipher, section_title)" +
            " values(?,?)";

    @Override
    public ScientificDirection getScientificDirectionById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_DIRECTION, new Object[] { id }, new DirectionMapper());
    }

    @Override
    public List<ScientificDirection> getAllScientificDirection() {
        return jdbcTemplate.query(SQL_GET_ALL_DIRECTIONS, new DirectionMapper());
    }

    @Override
    public boolean deleteScientificDirection(ScientificDirection scientificDirection) {
        return jdbcTemplate.update(SQL_DELETE_DIRECTION, scientificDirection.getCipher()) > 0;
    }

    @Override
    public void createScientificDirection(ScientificDirection scientificDirection) {
        jdbcTemplate.update(SQL_INSERT_DIRECTION, scientificDirection.getCipher(), scientificDirection.getSectionTitle());
    }

    @Override
    public boolean updateDirection(Long id, String column, String value) {
        String SQL_UPDATE_SCIENTIST = "update scientific_directions set " + column + "= ? where cipher = ?";
        return jdbcTemplate.update(SQL_UPDATE_SCIENTIST, value, id) > 0;
    }
}
