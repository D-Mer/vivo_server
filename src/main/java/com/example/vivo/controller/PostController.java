package com.example.vivo.controller;

import com.example.vivo.bl.PostService;
import com.example.vivo.vo.OrderForm;
import com.example.vivo.vo.PostForm;
import com.example.vivo.vo.PostsVO;
import com.example.vivo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Action;
import javax.xml.ws.Response;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/getPosts")
    public ResponseVO getPosts(@RequestBody String email){
        return postService.showPosts(email);
    }

    @PostMapping("/getPostById")
    public ResponseVO getPostById(@RequestBody int id){
        return null;
    }

    @PostMapping("/addPost")
    public ResponseVO addPosts(@RequestBody PostForm postForm){
        return postService.addPosts(postForm);
    }

    @PostMapping("/takeOrder")
    public ResponseVO takeOrder(@RequestBody OrderForm orderForm){
        return postService.takeOrder(orderForm);
    }

    @PostMapping("/giveUp")
    public ResponseVO giveUp(@RequestBody OrderForm orderForm){
        return postService.giveUp(orderForm);
    }

    @PostMapping("/completePost")
    public ResponseVO complete(@RequestBody String postId){
        return postService.completePost(postId);
    }

    @PostMapping("/selectPostByMajor")
    public ResponseVO selectPostByMajor(int major){
        return postService.selectPostByMajor(major);
    }

    @PostMapping("/delPost")
    public ResponseVO delPost(int postId){
        return postService.delPost(postId);
    }



}
