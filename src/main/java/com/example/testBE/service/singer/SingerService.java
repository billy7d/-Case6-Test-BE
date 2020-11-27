package com.example.testBE.service.singer;

import com.example.testBE.model.Singer;
import com.example.testBE.model.Song;

import java.util.Optional;

public interface SingerService {
    Iterable<Singer> findAll();

    Singer save(Singer singer);

    Optional<Singer> findSingerById(Long id);

    void deleteById(Long id);
}
