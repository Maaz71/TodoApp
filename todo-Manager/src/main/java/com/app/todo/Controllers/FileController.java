package com.app.todo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger = LoggerFactory.getLogger((FileController.class));

    @PostMapping("/single")
    public String uploadSingle(@RequestParam ("image")MultipartFile image)
    {
        logger.info("File name:{}",image.getOriginalFilename());
        logger.info("File type:{}",image.getContentType());

        return "File Test";
    }

    @PostMapping("/multi-file")
    public String uploadMulti(@RequestParam("file") MultipartFile[] files)
    {
        Arrays.stream(files).forEach(file->
        {
            logger.info("File name:{}",file.getOriginalFilename());
            logger.info("File type:{}",file.getContentType());
            System.out.println("++++++++++++++++++++++++++");
        });

        return "Multi-file test";
    }
}
