package com.example.club.controller;

import com.example.club.entity.Club;
import com.example.club.repository.ClubRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClubController {

    private final ClubRepository clubRepository;

    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    // ✅ Ahora solo maneja /clubes
    @GetMapping("/clubes")
    public String index(Model model) {
        model.addAttribute("clubes", clubRepository.findAll());
        return "clubes";
    }

    @GetMapping("/club/{id}")
    public String detalleClub(@PathVariable Long id, Model model) {
        Club club = clubRepository.findById(id).orElse(null);
        model.addAttribute("club", club);
        return "detalle_club";
    }
}
