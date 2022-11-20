package com.example.db_lab4.controllers;

import com.example.db_lab4.dao.ScientistDAO;
import com.example.db_lab4.entities.Scientist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/scientist")
public class ScientistController {
    private final ScientistDAO scientistDAO;

    @Autowired
    public ScientistController(ScientistDAO scientistDAO) {
        this.scientistDAO = scientistDAO;
    }

    @GetMapping()
    public String scientist(Model model) {
        List<Scientist> scientistList = scientistDAO.getAllScientists();
        model.addAttribute("scientists", scientistList);
        return "scientist";
    }

    @GetMapping("/add")
    public String scientistMethods() {
        return "scientist_add";
    }

    @PostMapping("/add")
    public String scientistAdd(@RequestParam String Last_Name, @RequestParam String First_Name,
                               @RequestParam String Patronymic,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate Birthday,
                               @RequestParam String Academic_Degree, @RequestParam String Academic_Title,
                               Model model) {
        Scientist scientist = new Scientist(Last_Name, First_Name, Patronymic, Birthday, Academic_Degree, Academic_Title);
        scientistDAO.createScientist(scientist);
        return "result";
    }

    @GetMapping("/remove")
    public String scientistRemoveForm() {
        return "scientist_remove";
    }

    @PostMapping("/remove")
    public String scientistRemove(@RequestParam Long id, Model model) {
        scientistDAO.deleteScientist(scientistDAO.getScientistById(id));
        return "remove";
    }

    @GetMapping("/update")
    public String scientistUpdateForm() {
        return "scientist_update";
    }

    @PostMapping("/update")
    public String scientistUpdate(@RequestParam Long Id, @RequestParam String Column, @RequestParam String Value) {
        scientistDAO.updateScientist(Id, Column, Value);
        return "update";
    }

}
