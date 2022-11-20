package com.example.db_lab4.models;

import com.example.db_lab4.entities.Member;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberMapper implements RowMapper<Member> {
    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        Member member = new Member();
        member.setId(rs.getLong("id"));
        member.setGrantSupervisor(rs.getLong("grant_supervisor"));
        member.setScientist(rs.getLong("scientist"));
        member.setGrantParticipant(rs.getLong("grant_participant"));
        return member;
    }
}
