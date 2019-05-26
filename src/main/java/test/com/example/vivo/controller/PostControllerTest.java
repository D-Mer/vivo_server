package test.com.example.vivo.controller; 

import com.example.vivo.bl.PostService;
import com.example.vivo.po.PostPO;
import com.example.vivo.vo.PostVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
* PostController Tester. 
* 
* @author <Authors name> 
* @since <pre>ÎåÔÂ 26, 2019</pre> 
* @version 1.0 
*/ 
public class PostControllerTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 
@Autowired
private PostService postService;

/** 
* 
* Method: getPosts(@RequestBody String email) 
* 
*/ 
@Test
public void testGetPosts() throws Exception { 
//TODO: Test goes here...
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
