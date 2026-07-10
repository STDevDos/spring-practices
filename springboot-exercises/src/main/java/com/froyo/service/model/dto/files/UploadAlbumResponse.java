package com.froyo.service.model.dto.files;

import com.froyo.messages.AbstractResponse;

public class UploadAlbumResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    private UploadAlbumRequest uploadAlbumRequest;

    public UploadAlbumRequest getUploadAlbumRequest() {
        return uploadAlbumRequest;
    }

    public void setUploadAlbumRequest(UploadAlbumRequest uploadAlbumRequest) {
        this.uploadAlbumRequest = uploadAlbumRequest;
    }

    @Override
    public String toString() {
        return "UploadAlbumResponse{" +
                "uploadAlbumRequest=" + uploadAlbumRequest +
                "} " + super.toString();
    }
}
