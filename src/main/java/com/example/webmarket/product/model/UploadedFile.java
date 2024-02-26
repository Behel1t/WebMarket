package com.example.webmarket.product.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Builder
@Setter
@Getter
public class UploadedFile {

    private MultipartFile file;

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}