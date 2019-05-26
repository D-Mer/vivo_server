package com.example.vivo.controller;

import com.example.vivo.bl.CommentService;
import com.example.vivo.vo.ReplyForm;
import com.example.vivo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/replyPost")
    public ResponseVO replyPost(@RequestBody ReplyForm replyForm){
        return commentService.replyPost(replyForm);
    }

    @PostMapping("/getCommentsByPostId")
    public ResponseVO getCommentsByPostId(@RequestParam int postId){
        return commentService.getCommentsByPostId(postId);
    }

    @PostMapping("/getNews")
    public ResponseVO getNews(@RequestParam String email){
        return commentService.getNews(email);
    }

}
