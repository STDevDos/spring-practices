package com.froyo.service.model.dto.files;

import com.froyo.messages.AbstractResponse;
import java.util.Objects;

public class UploadAlbumResponse extends AbstractResponse {

    private static final long serialVersionUID = 3141555321954313455L;
    private UploadAlbumRequest uploadAlbumRequest = new UploadAlbumRequest();

    public UploadAlbumRequest getUploadAlbumRequest() {
        return uploadAlbumRequest;
    }

    public void setUploadAlbumRequest(UploadAlbumRequest uploadAlbumRequest) {
        this.uploadAlbumRequest = uploadAlbumRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UploadAlbumResponse that = (UploadAlbumResponse) o;
        return Objects.equals(uploadAlbumRequest, that.uploadAlbumRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uploadAlbumRequest);
    }

    @Override
    public String toString() {
        return "UploadAlbumResponse{" +
                "uploadAlbumRequest=" + uploadAlbumRequest +
                "} " + super.toString();
    }
}
