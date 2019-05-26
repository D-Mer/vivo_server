package com.example.vivo.vo;

import lombok.Data;
import org.omg.DynamicAny.DynArray;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class PostForm {
    private String email;
    private String title;
    private int major;
    private int tagId;
    private String description;
    private MultipartFile picture;
    private double price;
}
