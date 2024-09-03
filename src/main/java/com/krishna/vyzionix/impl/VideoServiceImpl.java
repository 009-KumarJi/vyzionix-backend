package com.krishna.vyzionix.impl;

import com.krishna.vyzionix.entities.Video;
import com.krishna.vyzionix.services.VideoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Value("${video.upload.dir}")
    String DIR;

    @PostConstruct
    public void init() {
        File dir = new File(DIR);
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println("Directory created: " + DIR);
        } else {
            System.out.println("Directory already exists: " + DIR);
        }
    }

    @Override
    public Video saveVideo(Video video, MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename(); // Original file name
            String contentType = file.getContentType(); // Content type of the file
            InputStream inputStream = file.getInputStream(); // Input stream of the file

            // create folder path
            assert fileName != null;
            String cleanFileName = StringUtils.cleanPath(fileName);
            String cleanDirectory = StringUtils.cleanPath(DIR);

            Path path = Paths.get(cleanDirectory, cleanFileName); // file_path

            // Save the file
            System.out.println("File Path: " + path);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Video getVideoById(String videoId) {
        return null;
    }

    @Override
    public Video getVideoByTitle(String title) {
        return null;
    }

    @Override
    public List<Video> getAllVideos() {
        return null;
    }
}
