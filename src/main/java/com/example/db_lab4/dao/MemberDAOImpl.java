package com.example.db_lab4.dao;

import com.example.db_lab4.entities.Member;
import com.example.db_lab4.models.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberDAOImpl implements MemberDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_MEMBER = "select * from members where id = ?";
    private final String SQL_DELETE_MEMBER = "delete from members where id = ?";
    private final String SQL_UPDATE_MEMBER = "update members set grant_supervisor = ?, scientist = ?, grant_participant = ? " +
            "where id = ?";
    private final String SQL_GET_ALL_MEMBERS = "select * from members order by id asc";
    private final String SQL_INSERT_MEMBER = "insert into members(grant_supervisor, scientist, grant_participant)" +
            " values(?, ?, ?)";

    @Override
    public Member getMemberById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_MEMBER, new Object[] { id }, new MemberMapper());
    }

    @Override
    public List<Member> getAllMembers() {
        return jdbcTemplate.query(SQL_GET_ALL_MEMBERS, new MemberMapper());
    }

    @Override
    public boolean deleteMember(Member member) {
        return jdbcTemplate.update(SQL_DELETE_MEMBER, member.getId()) > 0;
    }

    @Override
    public void createMember(Member member) {
        jdbcTemplate.update(SQL_INSERT_MEMBER, member.getGrantSupervisor(), member.getScientist(),
                member.getGrantParticipant());
    }

    @Override
    public boolean updateMember(Long id, String column, Long value) {
        String SQL_UPDATE_MEMBER = "update members set " + column + "= ? where id = ?";
        return jdbcTemplate.update(SQL_UPDATE_MEMBER, value, id) > 0;
    }
}
