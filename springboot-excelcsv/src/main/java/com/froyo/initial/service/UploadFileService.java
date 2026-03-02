package com.froyo.initial.service;

import com.froyo.initial.MapObjectRowResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    MapObjectRowResponse uploadFile(MultipartFile file);
}
