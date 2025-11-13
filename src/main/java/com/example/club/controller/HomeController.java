package com.example.club.controller;

import com.example.club.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("clubes", clubRepository.findAll());
        return "clubes"; // Muestra la vista clubes.html
    }
}
