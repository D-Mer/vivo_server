package com.example.vivo.bl;

import com.example.vivo.vo.ResponseVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    ResponseVO saveFile(MultipartFile file, String email);
}
