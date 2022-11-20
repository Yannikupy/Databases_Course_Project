package com.example.db_lab4.dao;

import com.example.db_lab4.entities.Scientist;
import com.example.db_lab4.models.ScientistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Component
public class ScientistDAOImpl implements ScientistDAO{

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_SCIENTIST = "select * from scientists where id = ?";
    private final String SQL_DELETE_SCIENTIST = "delete from scientists where id = ?";
    private final String SQL_GET_ALL_SCIENTISTS = "select * from scientists order by id asc";
    private final String SQL_INSERT_SCIENTIST = "insert into scientists(last_name, first_name, patronymic, " +
                                                "birthday, academic_degree, academic_title) values(?,?,?,?,?,?)";



    @Autowired
    public ScientistDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Scientist getScientistById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_SCIENTIST, new Object[] { id }, new ScientistMapper());
    }

    @Override
    public List<Scientist> getAllScientists() {
        return jdbcTemplate.query(SQL_GET_ALL_SCIENTISTS, new ScientistMapper());
    }

    @Override
    public boolean deleteScientist(Scientist scientist) {
        return jdbcTemplate.update(SQL_DELETE_SCIENTIST, scientist.getId()) > 0;
    }

    @Override
    public boolean updateScientist(Long id, String column, Object value) {
        String SQL_UPDATE_SCIENTIST = "update scientists set " + column + "= ? where id = ?";
        if(column.equals("birthday")){
            value = LocalDate.parse(value.toString());
            return jdbcTemplate.update(SQL_UPDATE_SCIENTIST, value, id) > 0;
        }
        return jdbcTemplate.update(SQL_UPDATE_SCIENTIST, value.toString(), id) > 0;
    }

    @Override
    public void createScientist(Scientist scientist) {
        jdbcTemplate.update(SQL_INSERT_SCIENTIST, scientist.getLastName(), scientist.getFirstName(),
                scientist.getPatronymic(), scientist.getBirthday(), scientist.getAcademicDegree(), scientist.getAcademicTitle());
    }


}
