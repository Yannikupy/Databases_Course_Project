package com.example.db_lab4.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grant {
    private Long id;
    private String name;
    private Long amount;
    private Long sectionId;
    private Long realisationYear;

    public Grant(String name, Long amount, Long sectionId, Long realisationYear) {
        this.name = name;
        this.amount = amount;
        this.sectionId = sectionId;
        this.realisationYear = realisationYear;
    }
}
