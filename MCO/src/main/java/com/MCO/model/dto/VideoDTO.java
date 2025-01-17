package com.MCO.model.dto;

import com.MCO.model.Video;

public class VideoDTO {
    private Integer id;
    private String title;
    private String filePath;
    private String durationInSeconds;

    public VideoDTO(Video video) {
        this.id = video.getId();
        this.title = video.getTitle();
        this.filePath = video.getFilePath();
        this.durationInSeconds = video.getDurationInSeconds();
    }


    //  ***  METHOD   ***
// Metodo per ottenere solo il nome del file dal percorso completo
    private String extractFileName(String fullPath) {
        return fullPath.substring(fullPath.lastIndexOf("/") + 1);
    }

//  ***  GETTER AND SETTER   ***
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(String durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
}
