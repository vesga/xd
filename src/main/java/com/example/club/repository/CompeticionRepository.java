package com.example.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.club.entity.Competicion;

public interface CompeticionRepository extends JpaRepository<Competicion, Long> {
}
