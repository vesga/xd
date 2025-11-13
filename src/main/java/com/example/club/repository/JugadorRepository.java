package com.example.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.club.entity.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
