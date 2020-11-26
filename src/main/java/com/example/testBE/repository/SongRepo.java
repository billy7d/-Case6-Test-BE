package com.example.testBE.repository;

import com.example.testBE.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song,Long> {
}
