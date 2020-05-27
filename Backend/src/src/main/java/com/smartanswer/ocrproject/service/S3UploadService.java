package com.smartanswer.ocrproject.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface S3UploadService {

    String upload(MultipartFile multipartFile, String dirName) throws IOException;


    String upload(File uploadFile, String dirName);

    List<String> getBucketItems();
}
