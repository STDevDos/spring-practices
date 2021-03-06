package com.froyo.service.model.util.files;

import lombok.Data;

import java.io.Serializable;

@Data
public class MultipartFileData implements Serializable {

    private static final long serialVersionUID = 3989818823419352316L;

    private byte[] bytes;
    private String contentType;
    private String originalFilename;
    private Long size;

}
