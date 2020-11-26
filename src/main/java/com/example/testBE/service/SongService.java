package com.example.testBE.service;

import com.example.testBE.model.Song;

import java.util.Optional;

public interface SongService {
    Iterable<Song> findAll();

    Song save(Song song);

    Optional<Song> findById(Long id);

    void deleteById(Long id);
}
