package com.example.testBE.service.singer;

import com.example.testBE.model.Singer;
import com.example.testBE.repository.SingerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    SingerRepo singerRepo;

    @Override
    public Iterable<Singer> findAll() {
        return singerRepo.findAll();
    }

    @Override
    public Singer save(Singer singer) {
        singerRepo.save(singer);
        return singer;
    }

    @Override
    public Optional<Singer> findSingerById(Long id) {
        return singerRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        singerRepo.deleteById(id);
    }
}
