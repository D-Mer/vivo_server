package com.example.vivo.bl;

import com.example.vivo.vo.ResponseVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    ResponseVO saveFileForUser(MultipartFile file, String email);
}
