package com.example.testBE.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
@Data
@Entity
public class Song {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

//        private String description;

        @Transient
        private MultipartFile fileMp3;

        private String linkMp3;

//        @Transient
//        private MultipartFile avatar;
//        private String image;
}
