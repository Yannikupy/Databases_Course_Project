package com.example.db_lab4.dao;

import com.example.db_lab4.entities.Scientist;

import java.util.List;

public interface ScientistDAO {
    Scientist getScientistById(Long id);

    List<Scientist> getAllScientists();

    boolean deleteScientist(Scientist scientist);

    boolean updateScientist(Long id, String column, Object value);

    void createScientist(Scientist scientist);
}
