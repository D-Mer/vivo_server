package com.example.vivo;

import com.example.vivo.bl.PostService;
import com.example.vivo.vo.PostForm;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** 
* PostController Tester. 
* 
* @author <Authors name> 
* @since <pre>ÎåÔÂ 26, 2019</pre> 
* @version 1.0 
*/ 
public class PostControllerTest extends LoginApplicationTests {


    @Autowired
    PostService postService;
/** 
* 
* Method: getPosts(@RequestBody String email) 
* 
*/ 
@Test
public void testGetPosts() throws Exception { 
//TODO: Test goes here..


} 

/** 
* 
* Method: getPostById(@RequestBody int id) 
* 
*/ 
@Test
public void testGetPostById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addPosts(@RequestBody PostForm postForm) 
* 
*/ 
@Test
public void testAddPosts() throws Exception { 
//TODO: Test goes here...
    PostForm postForm=new PostForm();
    postForm.setDescription("ddd");
    postForm.setMajor(1);
    postForm.setPrice(10);
    postForm.setTitle("ddddd");
    postForm.setEmail("1");
    postService.addPosts(postForm);
    Assert.assertSame("fail","1",postService.getPostById(1) );
} 

/** 
* 
* Method: takeOrder(@RequestBody OrderForm orderForm) 
* 
*/ 
@Test
public void testTakeOrder() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: giveUp(@RequestBody OrderForm orderForm) 
* 
*/ 
@Test
public void testGiveUp() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: complete(@RequestBody String postId) 
* 
*/ 
@Test
public void testComplete() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: selectPostByMajor(int major) 
* 
*/ 
@Test
public void testSelectPostByMajor() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: delPost(int postId) 
* 
*/ 
@Test
public void testDelPost() throws Exception { 
//TODO: Test goes here...

} 


} 
