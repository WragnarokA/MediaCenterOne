package com.MCO.controller;

import com.MCO.model.Video;
import com.MCO.repository.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/videos")
@CrossOrigin // Consente richieste cross-origin
public class VideoRestController {

    @Autowired
    private VideoRepository videoRepository;

    // Endpoint per ottenere tutti i video
    @GetMapping
    public List<Video> index() {
        return videoRepository.findAll();
    }

    // Endpoint per creare un nuovo video
    @PostMapping
    public Video create(@RequestBody @Valid Video video) {
        // La validazione viene eseguita tramite l'annotazione @Valid
        return videoRepository.save(video);
    }


    ///// *** Caricamento del video in Locale ***
    @PostMapping("/upload")
    public Video uploadVideo(@RequestParam("file") MultipartFile file, @RequestParam("title") String title) {
        // Verifica la dimensione del file
        if (file.getSize() > 300 * 1024 * 1024) { // 300MB
            throw new RuntimeException("Il file è troppo grande. La dimensione massima consentita è 300MB.");
        }

        try {
            // Salva il file localmente
            String fileName = file.getOriginalFilename();
            String filePath = "src/main/resources/videos/" + fileName;
            file.transferTo(new File(filePath));

            // Salva il video nel database
            Video video = new Video();
            video.setTitle(title);
            video.setFilePath(filePath);  // Salva il percorso del file
            videoRepository.save(video);

            return video;
        } catch (IOException e) {
            throw new RuntimeException("Errore durante il caricamento del file", e);
        }
    }





    // (Facoltativo) Endpoint per ottenere un video per ID
    @GetMapping("/{id}")
    public Video getById(@PathVariable Long id) {
        return videoRepository.findById(Math.toIntExact(id)).orElse(null); // Ritorna il video o null se non trovato
    }

    // (Facoltativo) Endpoint per aggiornare un video esistente
    @PutMapping("/{id}")
    public Video update(@PathVariable Long id, @RequestBody @Valid Video video) {
        // Verifica se il video esiste già
        if (!videoRepository.existsById(Math.toIntExact(id))) {
            return null; // O lancia un'eccezione se necessario
        }
        video.setId(Math.toIntExact(id)); // Assicurati che l'ID del video sia corretto
        return videoRepository.save(video);
    }

    // (Facoltativo) Endpoint per eliminare un video
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        videoRepository.deleteById(Math.toIntExact(id));
    }
}
