package com.froyo.initial.service.impl;

import com.froyo.initial.MapObjectRowResponse;
import com.froyo.initial.service.UploadFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements UploadFileService {
    @Override
    public MapObjectRowResponse uploadFile(MultipartFile file) {
        MapObjectRowResponse response = new MapObjectRowResponse();
        // Dummy implementation to allow compilation
        return response;
    }
}
