package com.froyo.initial.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {

    public void uploadFile(MultipartFile file) {
        System.out.println("Uploading file: " + file.getOriginalFilename());
    }
}
