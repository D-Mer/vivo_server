package com.example.vivo;

import com.example.vivo.bl.PostService;
import com.example.vivo.po.PostPO;
import com.example.vivo.vo.OrderForm;
import com.example.vivo.vo.PostForm;
import com.example.vivo.vo.PostVO;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/** 
* PostController Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 26, 2019</pre> 
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
    PostPO postPO=new PostPO();
    postPO.setId(16);
    postPO.setEmail("1");
    postPO.setTitle("ddddd");
    postPO.setDescription("ddd");
    postPO.setUrls("C:\\Users\\jason\\Pictures\\1\\1.png");
    postPO.setCommentIds(null);
    postPO.setMajor(1);
    postPO.setTag("0");
    postPO.setPrice(10.0);
    String d="";
    String dateString = "2019-05-27 01:33:28";
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = df.parse(dateString);
    postPO.setStartTime(date);
    postPO.setEndTime(null);
    postPO.setCommentNum(0);
    postPO.setOrderTakerEmail("1");
    PostVO postVO=new PostVO(postPO);
    Assert.assertSame("fail",postVO,postService.getPostById(16).getContent());
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
    postForm.setPrice(10.0);
    postForm.setTitle("ddddd");
    postForm.setEmail("1");
    File f=new File("C:"+File.separator+"Users"+File.separator+"jason"+File.separator+"Pictures"+File.separator+"1.png");
    FileInputStream input = new FileInputStream(f);
    MultipartFile multipartFile = new MockMultipartFile("f", f.getName(), "text/plain", IOUtils.toByteArray(input));
    postForm.setPicture((List<MultipartFile>) multipartFile);
    Assert.assertSame("fail","C:"+File.separator+"Users"+File.separator+"jason"+File.separator+"Pictures"+File.separator+"1"+File.separator+"1.png",postService.addPosts(postForm).getContent() );
} 

/** 
* 
* Method: takeOrder(@RequestBody OrderForm orderForm) 
* 
*/ 
@Test
public void testTakeOrder() throws Exception { 
//TODO: Test goes here...
    OrderForm orderForm=new OrderForm();
    orderForm.setPostId(17);
    orderForm.setEmail("22");
    Assert.assertSame("fail",true,postService.takeOrder(orderForm).getContent());
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
