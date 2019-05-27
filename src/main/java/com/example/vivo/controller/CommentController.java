package com.example.vivo.controller;

import com.example.vivo.bl.CommentService;
import com.example.vivo.vo.ReplyForm;
import com.example.vivo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/replyPost")
    public ResponseVO replyPost(@RequestParam("postId") int postId, @RequestParam("firstCommentId") String firstCommentId, @RequestParam("secondCommentId") String secondCommentId, @RequestParam("email") String email, @RequestParam("content") String content, @RequestParam("pictures") List<MultipartFile> pictures){
        ReplyForm replyForm = new ReplyForm();
        replyForm.setPostId(postId);
        replyForm.setFirstCommentId(firstCommentId.isEmpty() ? 0 : Integer.parseInt(firstCommentId));
        replyForm.setSecondCommentId(secondCommentId.isEmpty() ? 0 : Integer.parseInt(secondCommentId));
        replyForm.setEmail(email);
        replyForm.setContent(content);
        replyForm.setPictures(pictures);
        return commentService.replyPost(replyForm);
    }

    @PostMapping("/getCommentsByPostId")
    public ResponseVO getCommentsByPostId(@RequestParam int postId){
        return commentService.getCommentsByPostId(postId);
    }

}
