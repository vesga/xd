package com.example.club.controller;

import com.example.club.entity.Club;
import com.example.club.repository.ClubRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubController {

    private final ClubRepository clubRepository;

    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @GetMapping
    public List<Club> listarClubes() {
        return clubRepository.findAll();
    }

    @GetMapping("/{id}")
    public Club obtenerClub(@PathVariable Long id) {
        return clubRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Club crearClub(@RequestBody Club club) {
        return clubRepository.save(club);
    }

    @DeleteMapping("/{id}")
    public void eliminarClub(@PathVariable Long id) {
        clubRepository.deleteById(id);
    }
}
