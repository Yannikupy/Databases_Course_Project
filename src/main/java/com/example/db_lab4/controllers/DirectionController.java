package com.example.db_lab4.controllers;

import com.example.db_lab4.dao.ScientificDirectionDAO;
import com.example.db_lab4.entities.ScientificDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/scientific_direction")
public class DirectionController {
    private final ScientificDirectionDAO scientificDirectionDAO;

    @Autowired
    public DirectionController(ScientificDirectionDAO scientificDirectionDAO) {
        this.scientificDirectionDAO = scientificDirectionDAO;
    }

    @GetMapping()
    public String scientific_direction(Model model) {
        List<ScientificDirection> scientificDirection = scientificDirectionDAO.getAllScientificDirection();
        model.addAttribute("directions", scientificDirection);
        return "scientific_direction";
    }
    @GetMapping("/add")
    public String scientistMethods(Model model) {
        return "scientific_direction_add";
    }

    @PostMapping("/add")
    public String scientificDirectionAdd(@RequestParam Long Cipher, @RequestParam String Section_Title)
    {
       ScientificDirection scientificDirection = new ScientificDirection(Cipher, Section_Title);
       scientificDirectionDAO.createScientificDirection(scientificDirection);
        return "result";
    }

    @GetMapping("/remove")
    public String scientificDirectionsRemoveForm(Model model) {
        return "scientific_direction_remove";
    }

    @PostMapping("/remove")
    public String scientificDirectionsRemove(@RequestParam Long Cipher, Model model) {
        scientificDirectionDAO.deleteScientificDirection(scientificDirectionDAO.getScientificDirectionById(Cipher));
        return "remove";
    }

    @GetMapping("/update")
    public String scientificDirectionUpdateForm() {
        return "direction_update";
    }

    @PostMapping("/update")
    public String scientificDirectionUpdate(@RequestParam Long Id, @RequestParam String Column, @RequestParam String Value) {
        scientificDirectionDAO.updateDirection(Id, Column, Value);
        return "update";
    }

}
