package com.example.db_lab4.dao;

import com.example.db_lab4.entities.Grant;

import java.util.List;

public interface GrantDAO {Grant getGrantById(Long id);

    List<Grant> getAllGrants();

    boolean deleteGrant(Grant grant);


    boolean updateGrant(Long id, String column, String value);

    void createGrant(Grant grant);

}
