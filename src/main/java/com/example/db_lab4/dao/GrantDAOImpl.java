package com.example.db_lab4.dao;

import com.example.db_lab4.entities.Grant;
import com.example.db_lab4.models.GrantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class GrantDAOImpl implements GrantDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_GRANT = "select * from grants where id = ?";
    private final String SQL_DELETE_GRANT = "delete from grants where id = ?";
    private final String SQL_GET_ALL_GRANTS = "select * from grants order by id asc";
    private final String SQL_INSERT_GRANT = "insert into grants(name, amount, section_id, realisation_year)" +
            " values(?, ?, ?, ?)";

    @Override
    public Grant getGrantById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_GRANT, new Object[] { id }, new GrantMapper());
    }

    @Override
    public List<Grant> getAllGrants() {
        return jdbcTemplate.query(SQL_GET_ALL_GRANTS, new GrantMapper());
    }

    @Override
    public boolean deleteGrant(Grant grant) {
        return jdbcTemplate.update(SQL_DELETE_GRANT, grant.getId()) > 0;
    }

    @Override
    public boolean updateGrant(Long id, String column, String value) {
        String SQL_UPDATE_GRANT = "update grants set " + column + "= ? where id = ?";
        if(Objects.equals(column, "name")) {
            return jdbcTemplate.update(SQL_UPDATE_GRANT, value, id) > 0;
        }
        return jdbcTemplate.update(SQL_UPDATE_GRANT, Integer.valueOf(value), id) > 0;
    }

    @Override
    public void createGrant(Grant grant) {
        jdbcTemplate.update(SQL_INSERT_GRANT, grant.getName(), grant.getAmount(),
                grant.getSectionId(), grant.getRealisationYear());
    }
}
