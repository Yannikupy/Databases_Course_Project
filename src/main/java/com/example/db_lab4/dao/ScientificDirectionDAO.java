package com.example.db_lab4.dao;

import com.example.db_lab4.entities.ScientificDirection;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ScientificDirectionDAO {
    ScientificDirection getScientificDirectionById(Long id);

    List<ScientificDirection> getAllScientificDirection();

    boolean deleteScientificDirection(ScientificDirection scientificDirection);

    void createScientificDirection(ScientificDirection scientificDirection);

    boolean updateDirection(Long id, String column, String value);
}
