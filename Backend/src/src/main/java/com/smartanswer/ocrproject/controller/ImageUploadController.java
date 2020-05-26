package com.smartanswer.ocrproject.controller;

import com.smartanswer.ocrproject.model.CustomResponse;
import com.smartanswer.ocrproject.service.S3UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/upload")
public class ImageUploadController {

    @Value("${cloud.aws.s3.folderName}")
    private String folderName;

    @Autowired
    private S3UploadService s3UploadService;

    @PostMapping("/")
    public String UploadImg(@RequestParam("imgFile")MultipartFile multipartFile) throws IOException{
        return s3UploadService.upload(multipartFile,folderName);
    }

    @GetMapping("/files")
    public CustomResponse getFiles(){
        try{
            return new CustomResponse("success","성공적으로 이미지 목록을 불러왔습니다.",s3UploadService.getBucketItems());
        }catch (Exception e){
            return new CustomResponse("error","이미지 목록을 불러오는데 실패했습니다.",e.getMessage());
        }
    }

}