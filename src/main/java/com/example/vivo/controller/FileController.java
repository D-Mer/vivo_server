package com.example.vivo.controller;

import com.example.vivo.bl.FileService;
import com.example.vivo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseVO upload(HttpServletRequest request){
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("avatar");
        System.out.println(params.getParameter("email"));
        System.out.println(params.getParameter("password"));
        return fileService.saveFile(file,"");
    }

}
