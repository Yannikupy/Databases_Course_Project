package com.example.db_lab4.dao;

import com.example.db_lab4.entities.Member;

import java.util.List;

public interface MemberDAO {

    Member getMemberById(Long id);

    List<Member> getAllMembers();

    boolean deleteMember(Member member);

    void createMember(Member member);

    boolean updateMember(Long id, String column, Long value);
}
