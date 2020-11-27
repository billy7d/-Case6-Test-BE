package com.example.testBE.controller;

import com.example.testBE.model.Singer;
import com.example.testBE.service.singer.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/singers")
public class SingerController {

    @Autowired
    private SingerService singerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Singer>> getAllSinger(){
        return new ResponseEntity<Iterable<Singer>>(singerService.findAll(), HttpStatus.OK);
    }
}
