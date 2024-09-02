package com.krishna.vyzionix.controllers;

import com.krishna.vyzionix.entities.Video;
import com.krishna.vyzionix.payload.CustomMessage;
import com.krishna.vyzionix.services.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

    private final VideoService videoService;
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public ResponseEntity<CustomMessage> create(
            @RequestParam("title") String title,
            @RequestParam("file") MultipartFile file,
            @RequestParam("description") String description
    ) {
        Video video = new Video();
        video.setTitle(title);
        video.setDescription(description);
        video.setVideoId(UUID.randomUUID().toString());
        videoService.saveVideo(video, file);
    return null;
    }
}
