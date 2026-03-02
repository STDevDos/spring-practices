package com.froyo.service.services.files.impl;

import com.froyo.service.model.dto.files.UploadAlbumResponse;
import com.froyo.service.services.files.FilesService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesServiceImpl implements FilesService {
    @Override
    public UploadAlbumResponse uploadAlbum(MultipartFile file) {
        UploadAlbumResponse response = new UploadAlbumResponse();
        // Dummy implementation
        return response;
    }
}
