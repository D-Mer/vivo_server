package com.example.vivo.blImpl;

import com.example.vivo.bl.FileService;
import com.example.vivo.vo.ResponseVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService, FileServiceForBL {

//    private static final String filePath = "/usr/files/";
//    private static final String Seperater = "/";
    private static final String filePath = "E:\\vivo马拉松\\vivo_server\\";
    private static final String Seperater = "\\";



    public ResponseVO saveFile(MultipartFile file, String index) {
        ResponseVO response;
        if (file == null || file.getOriginalFilename()==null){
            response = ResponseVO.buildFailure(false);
            response.setMessage("文件不存在或文件名为空");
            return response;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);

        String finalPath = filePath  + (index.isEmpty() ? "" : index + Seperater) + fileName;
        System.out.println("文件存储路径为：" + finalPath + fileName);

        // 创建一个新文件
        File dest = new File(finalPath);

        if (!dest.exists()){
            new File(dest.getParent()).mkdirs();
        }
        try {
            file.transferTo(dest);// 把file文件写入dest
        } catch (IOException e) {
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setMessage("文件在写入过程中失败，路径为：" + finalPath);
            return response;
        }
        response = ResponseVO.buildSuccess(finalPath);
        response.setMessage("文件上传成功，存储路径为：" + finalPath);
        return response;
    }
}
