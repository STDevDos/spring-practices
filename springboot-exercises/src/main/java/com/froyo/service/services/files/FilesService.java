package com.froyo.service.services.files;

import com.froyo.service.model.dto.files.UploadAlbumResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FilesService {
    UploadAlbumResponse uploadAlbum(MultipartFile file);
}
