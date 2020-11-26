package com.example.testBE.controller;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.testBE.model.Song;
import com.example.testBE.service.SongService;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {


    final String CLOUDINARY_URL = "cloudinary://292468957674773:lcLLj26C4VX82SHtbJrjZkcwhas@dos9lacv4";

   @Autowired
   SongService songService;


    @PostMapping("/create")
    public ResponseEntity<Song> createSong(@RequestParam("imageFile") MultipartFile multipartFile){

        Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
        Song newSong = new Song();
        try{
            File mp3File = File.createTempFile("test", multipartFile.getOriginalFilename()).toPath().toFile();
            multipartFile.transferTo(mp3File);

            Map responseMp3 = cloudinary.uploader().upload(mp3File,  ObjectUtils.asMap("resource_type", "auto"));
            JSONObject jsonObject = new JSONObject(responseMp3);
            String urlMp3 = jsonObject.getString("url");

            newSong.setLinkMp3(urlMp3);
        } catch ( IOException e) {
            e.printStackTrace();
            e.getMessage();
        }


        songService.save(newSong);
        return new ResponseEntity<Song>(newSong, HttpStatus.OK);
    }

    @GetMapping("/getFile")
    public ResponseEntity<Iterable<Song>> getFile(){
        return new ResponseEntity<Iterable<Song>>(songService.findAll(),HttpStatus.OK);
    }
}
