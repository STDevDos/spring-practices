package com.froyo.initial.restcontroller;

import com.froyo.initial.MapObjectRowResponse;
import com.froyo.initial.service.UploadFileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class InitialRestController {

    private final UploadFileService uploadFileService;

    public InitialRestController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @PostMapping("/upload")
    public MapObjectRowResponse uploadFile(@RequestParam("file") MultipartFile file) {
        return uploadFileService.uploadFile(file);
    }

}
