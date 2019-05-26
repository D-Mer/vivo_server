package com.example.vivo.bl;

import com.example.vivo.vo.OrderForm;
import com.example.vivo.vo.PostForm;
import com.example.vivo.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sound.sampled.ReverbType;

public interface PostService {

    /*
    * @param PostForm
    * @return
    */
    ResponseVO showPosts(String email);


    ResponseVO addPosts(PostForm postForm);

    ResponseVO takeOrder(OrderForm orderForm);

    ResponseVO giveUp(OrderForm orderForm);

    ResponseVO completePost(String postId);
}
