package com.MCO.repository;

import com.MCO.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    List<Video> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);

}
