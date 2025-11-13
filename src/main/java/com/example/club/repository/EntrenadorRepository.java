package com.example.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.club.entity.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
}
