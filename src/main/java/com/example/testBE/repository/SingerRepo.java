package com.example.testBE.repository;

import com.example.testBE.model.Singer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepo extends JpaRepository<Singer,Long> {
}
