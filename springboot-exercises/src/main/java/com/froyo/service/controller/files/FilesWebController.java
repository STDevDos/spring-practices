package com.froyo.service.controller.files;

import com.froyo.service.model.dto.files.UploadAlbumResponse;
import com.froyo.service.services.files.FilesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FilesWebController {

    private static final Logger log = LogManager.getLogger(FilesWebController.class);

    private final FilesService filesService;

    public FilesWebController(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostMapping("/uploadAlbum")
    public UploadAlbumResponse uploadAlbum(@RequestParam("file") MultipartFile file) {
        log.info("uploadAlbum...");
        return filesService.uploadAlbum(file);
    }

}
