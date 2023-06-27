package com.example.booksellersystem.controller;

import com.example.booksellersystem.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
public class UploadController {
    @RequestMapping("/upload")
    public Result upload(String name, MultipartFile file) throws Exception{
       String filename = file.getOriginalFilename();
       //唯一UUID
        file.transferTo(new File("D:/main/"+ UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf('.'))));
        return Result.success();
    }
}
