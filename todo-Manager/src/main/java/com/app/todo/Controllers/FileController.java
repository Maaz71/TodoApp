package com.app.todo.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
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

    @GetMapping("/serve-image")
    public void serveImageHandler(HttpServletResponse response)
    {
        try{
            InputStream fileInput= new FileInputStream("images/docker.jpg");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInput,response.getOutputStream());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
