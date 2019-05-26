package com.example.vivo.controller;

import com.example.vivo.bl.FileService;
import com.example.vivo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class FileController {

    private static final String filePath = "/usr/files/";

//    @Autowired
//    FileService fileService;

    @PostMapping("/upload")
    public ResponseVO upload(@RequestParam("file") MultipartFile file){
        return saveFile(file);
    }

    private ResponseVO saveFile(MultipartFile file) {
        ResponseVO response;
        if (file == null || file.getOriginalFilename()==null){
            response = ResponseVO.buildFailure(false);
            response.setMessage("文件不存在或文件名为空");
            return response;
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);

//        // 设置文件存储路径
//        try {
//            path = ResourceUtils.getURL("classpath:").getPath();
//            System.out.println(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//            response = ResponseVO.buildFailure(false);
//            response.setMessage("文件路径获取失败");
//            return response;
//        }
        // 获取文件的后缀名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        System.out.println("文件的后缀名为：" + suffixName);

//        String finalPath = path + fileName;
//        System.out.println("文件存储路径为：" + finalPath);
        String finalPath = filePath + fileName;
        System.out.println("文件存储路径为：" + finalPath);

        // 创建一个新文件
        File dest = new File(fileName);
//        // 检测是否存在目录
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();// 新建文件夹
//        }
        try {
            file.transferTo(dest);// 把file文件写入dest
        } catch (IOException e) {
            e.printStackTrace();
            response = ResponseVO.buildFailure(false);
            response.setMessage("文件在写入过程中失败，路径为：" + finalPath);
            return response;
        }
        response = ResponseVO.buildSuccess(true);
        response.setMessage("文件上传成功，存储路径为：" + finalPath);
        return response;
    }

}
