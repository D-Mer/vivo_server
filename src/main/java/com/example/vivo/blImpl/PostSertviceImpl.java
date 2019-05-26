package com.example.vivo.blImpl;

import com.example.vivo.bl.PostService;
import com.example.vivo.data.post.PostMapper;
import com.example.vivo.po.PostPO;
import com.example.vivo.vo.OrderForm;
import com.example.vivo.vo.PostForm;
import com.example.vivo.vo.PostsVO;
import com.example.vivo.vo.ResponseVO;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class PostSertviceImpl implements PostService {

    @Autowired
    PostMapper postMapper;

    @Override
    public ResponseVO showPosts(String postForm){
        ResponseVO response;
        try {
            response  = ResponseVO.buildSuccess(selectPostsByTime(postMapper.selectPostsByTime()));
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
            response=ResponseVO.buildSuccess(postMapper.addPost(postForm));//数据库增加Post
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response=ResponseVO.buildFailure(null);
            response.setContent("失败");
            return response;
        }
    }

    @Override
    public ResponseVO takeOrder(OrderForm orderForm){
        ResponseVO response;
        try {
            response=ResponseVO.buildSuccess(postMapper.updatePostTaker(orderForm,0));
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response=ResponseVO.buildFailure(null);
            response.setContent("失败");
            return response;
        }
    }

    @Override
    public ResponseVO giveUp(OrderForm orderForm){
        ResponseVO response;
        try {
            response=ResponseVO.buildSuccess(postMapper.updatePostTaker(orderForm,1));
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response=ResponseVO.buildFailure(null);
            response.setContent("失败");
            return response;
        }
    }
    @Override
    public ResponseVO completePost(String postId){
        ResponseVO response;
        try {
            response=ResponseVO.buildSuccess(postMapper.completePost(postId));
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
            response=ResponseVO.buildSuccess(selectByMajor(postMapper.selectPostsByMajor(major),major));
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response=ResponseVO.buildFailure(null);
            response.setContent("失败");
            return response;
        }
    }

    private List<PostsVO> selectByMajor(List<PostPO> postList,int major){
        List<PostsVO> postsVOList =new ArrayList<>();
        for (PostPO post:postList){
            if (post.getMajor()==major)
            postsVOList.add(0,new PostsVO(post));
        }
        return postsVOList;
    }

    private List<PostsVO> selectPostsByTime(List<PostPO> postList){
        List<PostsVO> postsVOList =new ArrayList<>();
        for (PostPO post:postList){
            postsVOList.add(0,new PostsVO(post));
        }
        return postsVOList;
    }
}
