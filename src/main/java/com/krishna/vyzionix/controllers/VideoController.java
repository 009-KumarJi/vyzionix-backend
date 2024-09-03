package com.krishna.vyzionix.controllers;

import com.krishna.vyzionix.entities.Video;
import com.krishna.vyzionix.payload.CustomMessage;
import com.krishna.vyzionix.services.VideoService;
import com.krishna.vyzionix.utils.FileValidator;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> create(
            @RequestParam("title") String title,
            @RequestParam("file") MultipartFile file,
            @RequestParam("description") String description
    ) {
        if (!FileValidator.isValidContentType(file)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(CustomMessage.builder().message("Invalid content type").build());
        }

        Video video = new Video();
        video.setTitle(title);
        video.setDescription(description);
        video.setVideoId(UUID.randomUUID().toString());
         Video savedVideo = videoService.saveVideo(video, file);

        return (savedVideo != null)
                ? ResponseEntity.status(HttpStatus.OK).body(video)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CustomMessage.builder().message("Video not uploaded").build());
    }
}
