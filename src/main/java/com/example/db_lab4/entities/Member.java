package com.example.db_lab4.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Long id;
    private Long grantSupervisor;
    private Long scientist;
    private Long grantParticipant;

    public Member(Long grantSupervisor, Long scientist, Long grantParticipant) {
        this.grantSupervisor = grantSupervisor;
        this.scientist = scientist;
        this.grantParticipant = grantParticipant;
    }
}
