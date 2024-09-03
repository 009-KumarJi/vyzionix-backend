package com.krishna.vyzionix.utils;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public class FileValidator {

    private static final List<String> VALID_CONTENT_TYPES = Arrays.asList("video/mp4", "video/avi", "video/mkv");

    public static boolean isValidContentType(MultipartFile file) {
        String contentType = file.getContentType();
        return VALID_CONTENT_TYPES.contains(contentType);
    }
}