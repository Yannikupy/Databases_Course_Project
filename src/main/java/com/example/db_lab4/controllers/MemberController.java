package com.example.db_lab4.controllers;

import com.example.db_lab4.dao.MemberDAO;
import com.example.db_lab4.dao.MemberDAOImpl;
import com.example.db_lab4.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberDAO memberDAO;

    @Autowired
    public MemberController(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @GetMapping()
    public String member(Model model) {
        List<Member> scientistList = memberDAO.getAllMembers();
        model.addAttribute("members", scientistList);
        return "member";
    }

    @GetMapping("/add")
    public String memberMethods() {
        return "member_add";
    }

    @PostMapping("/add")
    public String memberAdd(@RequestParam Long GrantSupervisor, @RequestParam Long Scientist,
                               @RequestParam Long GrantParticipant) {
        Member member = new Member(GrantSupervisor, Scientist, GrantParticipant);
        memberDAO.createMember(member);
        return "result";
    }

    @GetMapping("/remove")
    public String memberRemoveForm() {
        return "member_remove";
    }

    @PostMapping("/remove")
    public String memberRemove(@RequestParam Long Id) {
        memberDAO.deleteMember(memberDAO.getMemberById(Id));
        return "remove";
    }

    @GetMapping("/update")
    public String memberUpdateForm() {
        return "member_update";
    }

    @PostMapping("/update")
    public String memberUpdate(@RequestParam Long Id, @RequestParam String Column, @RequestParam Long Value) {
        memberDAO.updateMember(Id, Column, Value);
        return "update";
    }
}
