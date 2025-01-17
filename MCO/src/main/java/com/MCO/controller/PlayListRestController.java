package com.MCO.controller;

import com.MCO.model.PlayList;
import com.MCO.model.Video;
import com.MCO.model.dto.PlaylistDTO;
import com.MCO.repository.PlayListRepository;
import com.MCO.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/playlists")
@CrossOrigin
public class PlayListRestController {

    @Autowired
    private PlayListRepository playListRepository;

    @Autowired
    private VideoRepository videoRepository;

    // Endpoint per creare una nuova playlist con video associati
    @PostMapping
    public PlayList createPlaylist(@RequestBody PlaylistDTO playlistDTO) {
        PlayList playlist = new PlayList();
        playlist.setName(playlistDTO.getName());

        // Recupera i video dal database in base agli ID forniti
        List<Video> videos = videoRepository.findAllById(playlistDTO.getVideoIds());

        // Se i video non vengono trovati, non aggiungere nessun video alla playlist
        if (videos.isEmpty()) {
            // Puoi scegliere di restituire una playlist vuota o farlo in altro modo
            playlist.setVideos(new ArrayList<>());
        } else {
            playlist.setVideos(videos);
        }

        // Salva la playlist, anche se vuota
        return playListRepository.save(playlist);
    }

    // Endpoint per ottenere i video di una specifica playlist
    @GetMapping("/{playlistId}/videos")
    public List<Video> getVideosByPlaylist(@PathVariable Integer playlistId) {
        PlayList playlist = playListRepository.findById(playlistId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Playlist non trovata"));

        return playlist.getVideos();
    }




    // Get la lista Playlist
    @GetMapping
    public List<PlayList> index() {
        return playListRepository.findAll();
    }
}
