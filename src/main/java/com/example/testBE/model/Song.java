package com.example.testBE.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
public class Song {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotEmpty
        @Size(min = 3)
        private String name;

        @NotEmpty
        @Size(min = 3)
        private String description;

        @Transient
        private MultipartFile fileMp3;
        private String linkMp3;

        @Transient
        private MultipartFile avatar;
        private String image;

        @NotEmpty
        private String author;

        @NotEmpty
        private String creator;

        @NotEmpty
        private String musicType;

        @NotEmpty
        private String album;

        @ManyToMany
        @JoinTable(name = "singer_song", joinColumns = @JoinColumn(name = "song_id"),
                inverseJoinColumns = @JoinColumn(name = "singer_id"))
        private List<Singer> singerName;

}




