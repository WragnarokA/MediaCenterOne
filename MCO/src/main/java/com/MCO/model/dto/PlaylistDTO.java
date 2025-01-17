package com.MCO.model.dto;

import java.util.List;

public class PlaylistDTO {
    private String name;
    private List<Integer> videoIds;

    public PlaylistDTO(String name, List<Integer> videoIds) {
        this.name = name;
        this.videoIds = videoIds;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getVideoIds() {
        return videoIds;
    }

    public void setVideoIds(List<Integer> videoIds) {
        this.videoIds = videoIds;
    }
}


