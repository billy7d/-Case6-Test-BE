package com.example.testBE.service;

import com.example.testBE.model.Song;
import com.example.testBE.repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongRepo songRepo;
    @Override
    public Iterable<Song> findAll() {
        return songRepo.findAll();
    }

    @Override
    public Song save(Song song) {
        songRepo.save(song);
        return song;
    }

    @Override
    public Optional<Song> findById(Long id) {

        return songRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        songRepo.deleteById(id);
    }
}
