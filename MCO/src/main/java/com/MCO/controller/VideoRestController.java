package com.MCO.controller;

import com.MCO.model.Video;
import com.MCO.model.dto.VideoDTO;
import com.MCO.repository.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
//

@RestController
@RequestMapping("/api/v1/videos")
@CrossOrigin
public class VideoRestController {

    @Autowired
    private VideoRepository videoRepository;

    // Endpoint per ottenere tutti i video
    @GetMapping
    public List<Video> index() {
        return videoRepository.findAll();
    }

    // Metodo per restituire un DTO invece degli oggetti video**********
    @GetMapping("/videos")
    public List<VideoDTO> getAllVideos() {
        return videoRepository.findAll().stream()
                .map(VideoDTO::new) // Converte ogni Video in VideoDTO
                .toList();
    }
    // Metodo per restituire i video staticamente**********
    @GetMapping("/videos/{fileName}")
    public ResponseEntity<Resource> getVideoFile(@PathVariable String fileName) {
        try {
            // Ottieni il percorso assoluto del file utilizzando Paths
            java.nio.file.Path filePath = Paths.get("uploaded_videos").resolve(fileName).toAbsolutePath();
            File file = filePath.toFile();

            // Verifica che il file esista
            if (!file.exists() || !file.isFile()) {
                return ResponseEntity.notFound().build();
            }

            // Crea la risorsa per il file
            UrlResource resource = new UrlResource(file.toURI());

            // Determina il tipo MIME
            MediaType mediaType = MediaTypeFactory.getMediaType(fileName)
                    .orElse(MediaType.APPLICATION_OCTET_STREAM);

            // Restituisci il file come risorsa
            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .body(resource);

        } catch (IOException e) {
            // Gestione degli errori
            return ResponseEntity.internalServerError().build();
        }
    }







    @PostMapping("/upload")
    public Video uploadVideo(@RequestParam("file") MultipartFile file, @RequestParam("title") String title,  @RequestParam("duration_in_seconds") String durationInSeconds) {
        // Verifica la dimensione del file
        if (file.getSize() > 300 * 1024 * 1024) { // 300MB
            throw new RuntimeException("Il file è troppo grande. La dimensione massima consentita è 300MB.");
        }

        try {
            // Crea la cartella "uploaded_videos" nella directory del progetto se non esiste
            File directory = new File("uploaded_videos");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Salva il file nella cartella "uploaded_videos"
            String fileName = file.getOriginalFilename();
            String filePath = directory.getAbsolutePath() + File.separator + fileName;
            file.transferTo(new File(filePath));

            // Salva il video nel database
            Video video = new Video();
            video.setTitle(title);
            video.setFilePath(filePath);
            video.setDurationInSeconds(durationInSeconds);
            System.out.println("durationInSeconds" + durationInSeconds);
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
