package com.example.vivo.blImpl;

import com.example.vivo.vo.ResponseVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceForBL {

    ResponseVO saveFile(MultipartFile file, String index);
}
