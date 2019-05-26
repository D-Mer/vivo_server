package com.example.vivo.vo;

import lombok.Data;
import org.omg.DynamicAny.DynArray;

import java.util.Date;
import java.util.List;

@Data
public class PostForm {
    private String email;
    private String title;
    private int major;
    private String tag;
    private String description;
    private String picture;
    private int price;
}
