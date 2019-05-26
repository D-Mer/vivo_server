package com.example.vivo.vo;

import lombok.Data;

@Data
public class ResponseVO {
    boolean isSuccess;
    private String message;
    private Object content;

    public static ResponseVO buildSuccess(Object content){
        ResponseVO response = new ResponseVO();
        response.setContent(content);
        response.setSuccess(true);
        return response;
    }

    public static ResponseVO buildFailure(Object content){
        ResponseVO response = new ResponseVO();
        response.setSuccess(false);
        response.setContent(content);
        return response;
    }
}

