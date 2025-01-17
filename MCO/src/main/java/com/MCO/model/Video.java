package com.MCO.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Titolo non deve essere vuoto")
    @Size(min = 5, max = 150, message = "La dimensione deve essere compresa tra 5 e 150")
    private String title;

    @NotBlank(message = "Non deve essere vuoto")
    private String filePath;
    private String thumbnailUrl;

//    @Max(1000)
    private String durationInSeconds;

    @Size(max = 550)
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime  uploadedBy; //  (FK → users.id): Indica chi ha caricato il video.

    @ManyToMany(mappedBy = "videos")
    @JsonIgnore
    private List<PlayList> playlists;


    //**** CONSTRUCTOR *****
    //**** METHOD *****
//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//    }

    //**** GETTER AND SETTER *****


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(String durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public LocalDateTime getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(LocalDateTime uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public List<PlayList> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlayList> playlists) {
        this.playlists = playlists;
    }
}
