package com.example.vivo.controller;

import com.example.vivo.bl.PostService;
import com.example.vivo.vo.OrderForm;
import com.example.vivo.vo.PostForm;
import com.example.vivo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/getPosts")
    public ResponseVO getPosts(@RequestParam("email") String email){
        return postService.showPosts(email);
    }

    @PostMapping("/getPostById")
    public ResponseVO getPostById(@RequestParam("id") int id){
        return postService.getPostById(id);
    }

//    @PostMapping("/addPost")
//    public ResponseVO addPosts(@RequestParam("picture") List<MultipartFile> picture, @RequestParam("title") String title, @RequestParam("email") String email, @RequestParam("major") String major, @RequestParam("description") String description, @RequestParam("price") double price){
//        PostForm postForm = new PostForm();
//        postForm.setPicture(picture);
//        postForm.setTitle(title);
//        postForm.setEmail(email);
//        postForm.setMajor(major.isEmpty() ? 0 : Integer.parseInt(major));
//        postForm.setDescription(description);
//        postForm.setPrice(price);
//        return postService.addPosts(postForm);
//    }
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
    public ResponseVO complete(@RequestParam("postId") int postId){
        return postService.completePost(postId);
    }

    @PostMapping("/selectPostByMajor")
    public ResponseVO selectPostByMajor(@RequestParam("major") int major){
        return postService.selectPostByMajor(major);
    }

    @PostMapping("/selectPostByEmail")
    public ResponseVO selectPostByEmail(@RequestParam("email") String email){
        return postService.selectPostByEmail(email);
    }

    @PostMapping("/selectOrderByEmail")
    public ResponseVO selectOrderByEmail(@RequestParam("email") String email){
        return postService.selectOrderByEmail(email);
    }

    @PostMapping("/delPost")
    public ResponseVO delPost(@RequestParam("postId") int postId){
        return postService.delPost(postId);
    }



}
