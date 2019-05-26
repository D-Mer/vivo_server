package com.example.vivo.blImpl;

import com.example.vivo.bl.PostService;
import com.example.vivo.data.post.PostMapper;
import com.example.vivo.po.PostPO;
import com.example.vivo.vo.OrderForm;
import com.example.vivo.vo.PostForm;
import com.example.vivo.vo.PostVO;
import com.example.vivo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostServiceImpl implements PostService {

    @Autowired
    PostMapper postMapper;

    @Override
    public ResponseVO showPosts(String email){
        ResponseVO response;
        try {
            List<PostPO> postPOList = postMapper.selectPostsByTime();
            List<PostVO> postVOList = new ArrayList<>();
            for (PostPO post:postPOList){
                postVOList.add(new PostVO(post));
            }
            response = ResponseVO.buildSuccess(postPOList);
            response.setMessage("查询成功");
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("失败");
            return response;
        }
    }

    @Override
    public ResponseVO getPostById(int id) {
        ResponseVO response;
        try{
            PostPO postPO = postMapper.selectPostById(id);
            PostVO postVO = new PostVO(postPO);
            response  = ResponseVO.buildSuccess(postVO);
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("失败");
            return response;
        }
    }

    @Override
    public ResponseVO addPosts(PostForm postForm){
        ResponseVO response;
        try {
            response = postMapper.addPost(postForm) ? ResponseVO.buildSuccess(null) : ResponseVO.buildFailure(null);//数据库增加Post
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("发生了未知错误");
            return response;
        }
    }

    @Override
    public ResponseVO takeOrder(OrderForm orderForm){
        ResponseVO response;
        try {
            response = ResponseVO.buildSuccess(postMapper.takeOrder(orderForm.getPostId(), orderForm.getEmail()));
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("失败");
            return response;
        }
    }

    @Override
    public ResponseVO giveUp(OrderForm orderForm){
        ResponseVO response;
        try {
            response = ResponseVO.buildSuccess(postMapper.giveUpPost(orderForm.getPostId()));
            //todo: 扣除信用积分
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("失败");
            return response;
        }
    }
    @Override
    public ResponseVO completePost(String postId){
        ResponseVO response;
        try {
            Date endTime = new Date();
            response=ResponseVO.buildSuccess(postMapper.completePost(postId, endTime));
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response=ResponseVO.buildFailure(null);
            response.setContent("失败");
            return response;
        }
    }

    public ResponseVO selectPostByMajor(int major){
        ResponseVO response;
        try{
            response=ResponseVO.buildSuccess(postMapper.selectPostsByMajor(major));
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response=ResponseVO.buildFailure(null);
            response.setContent("失败");
            return response;
        }
    }

    public ResponseVO delPost(int postId){
        ResponseVO response;
        try{
            response=ResponseVO.buildSuccess(postMapper.delPostById(postId));
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response=ResponseVO.buildFailure(null);
            response.setContent("失败");
            return response;
        }
    }


}
