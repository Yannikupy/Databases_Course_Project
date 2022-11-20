package com.example.db_lab4.controllers;

import com.example.db_lab4.dao.GrantDAO;
import com.example.db_lab4.entities.Grant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/grant")
public class GrantController {
    private final GrantDAO grantDAO;

    @Autowired
    public GrantController(GrantDAO grantDAO) {
        this.grantDAO = grantDAO;
    }

    @GetMapping()
    public String grant(Model model) {
        List<Grant> grants = grantDAO.getAllGrants();
        model.addAttribute("grants", grants);
        return "grant";
    }
    @GetMapping("/add")
    public String grantMethods() {
        return "grant_add";
    }

    @PostMapping("/add")
    public String grantAdd(@RequestParam String Name, @RequestParam Long Amount, @RequestParam Long SectionId,
                           @RequestParam Long RealisationYear)
    {
        Grant grant = new Grant(Name, Amount, SectionId, RealisationYear);
        grantDAO.createGrant(grant);
        return "result";
    }

    @GetMapping("/remove")
    public String grantRemoveForm(Model model) {
        return "grant_remove";
    }

    @PostMapping("/remove")
    public String grantRemove(@RequestParam Long Id) {
        grantDAO.deleteGrant(grantDAO.getGrantById(Id));
        return "remove";
    }

    @GetMapping("/update")
    public String grantUpdateForm() {
        return "grant_update";
    }

    @PostMapping("/update")
    public String grantUpdate(@RequestParam Long Id, @RequestParam String Column, @RequestParam String Value) {
        grantDAO.updateGrant(Id, Column, Value);
        return "update";
    }
}
