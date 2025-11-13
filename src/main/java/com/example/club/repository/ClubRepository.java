package com.example.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.club.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
