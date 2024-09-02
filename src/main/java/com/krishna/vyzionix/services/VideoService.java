package com.krishna.vyzionix.services;

import com.krishna.vyzionix.entities.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface VideoService {
    Video saveVideo(Video video, MultipartFile file);
    Video getVideoById(String videoId);
    Video getVideoByTitle(String title);
    List<Video> getAllVideos();
}
