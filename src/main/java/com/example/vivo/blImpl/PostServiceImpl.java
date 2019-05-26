package com.example.vivo.blImpl;

import com.example.vivo.bl.PostService;
import com.example.vivo.data.post.PostMapper;
import com.example.vivo.po.PostPO;
import com.example.vivo.vo.OrderForm;
import com.example.vivo.vo.PostForm;
import com.example.vivo.vo.PostVO;
import com.example.vivo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    FileServiceForBL fileService;

    @Autowired
    AccountServiceForBL accountService;

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
            response.setMessage("查询失败，原因未知");
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
            response.setMessage("查询成功");
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("查询失败，原因：目标不存在");
            return response;
        }
    }

    @Override
    public ResponseVO addPosts(PostForm postForm){
        ResponseVO response;
        try {
            StringBuilder url = new StringBuilder();
            String tempUrl;
            PostPO postPO;
            for (MultipartFile f : postForm.getPicture()) {
                if ((tempUrl = String.valueOf(fileService.saveFile(f, postForm.getEmail()).getContent())).equals("null")){
                    response = ResponseVO.buildFailure(null);
                    response.setMessage("发帖失败，原因：文件保存失败");
                    return response;
                }
                url.append(url.length() == 0 ? tempUrl : ","+tempUrl);
            }
            postPO = new PostPO(postForm, url.toString());
            postMapper.addPost(postPO);
            response = ResponseVO.buildSuccess(Arrays.asList(url.toString().split(",")));
            response.setMessage("发帖成功");
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
            if (postMapper.takeOrder(orderForm.getPostId(), orderForm.getEmail())){
                response = ResponseVO.buildSuccess(null);
                response.setMessage("接单成功");
            }else {
                response = ResponseVO.buildFailure(null);
                response.setMessage("接单失败，原因：订单不存在");
            }
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setMessage("接单失败，原因未知");
            return response;
        }
    }

    @Override
    public ResponseVO giveUp(OrderForm orderForm){
        ResponseVO response;
        try {
            if (!accountService.updateCredit(orderForm.getEmail(), -10)){
                response = ResponseVO.buildFailure(null);
                response.setContent("弃单失败，原因：信用分扣除失败");
                return response;
            }
            if (!postMapper.giveUpPost(orderForm.getPostId())){
                response = ResponseVO.buildFailure(null);
                response.setMessage("弃单失败，原因：订单不存在");
            }
            response = ResponseVO.buildSuccess(null);
            response.setMessage("弃单成功");
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("弃单失败，原因未知");
            return response;
        }
    }
    @Override
    public ResponseVO completePost(int postId){
        ResponseVO response;
        try {
            Date endTime = new Date();
            if (postMapper.completePost(postId, endTime)){
                response = ResponseVO.buildSuccess(null);
                response.setMessage("完成订单成功");
            }else {
                response = ResponseVO.buildFailure(null);
                response.setMessage("完成订单失败，原因：订单不存在");
            }
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("完成订单失败，未知错误");
            return response;
        }
    }

    public ResponseVO selectPostByMajor(int major){
        ResponseVO response;
        try{
            List<PostPO> postPOList = postMapper.selectPostByMajor(major);
            if (postPOList.size()!=0){
                response = ResponseVO.buildSuccess(postPOList);
                response.setMessage("获取订单成功");
            }else {
                response = ResponseVO.buildFailure(null);
                response.setMessage("获取订单失败，原因：该专业下无订单");
            }
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("获取订单失败，未知原因");
            return response;
        }
    }

    public ResponseVO selectPostByEmail(String email){
        ResponseVO response;
        try{
            List<PostPO> postPOList = postMapper.selectPostByEmail(email);
            if (postPOList.size()!=0){
                response = ResponseVO.buildSuccess(postPOList);
                response.setMessage("获取订单成功");
            }else {
                response = ResponseVO.buildFailure(null);
                response.setMessage("获取订单失败，原因：该用户无订单");
            }
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("获取订单失败，未知原因");
            return response;
        }
    }

    public ResponseVO selectOrderByEmail(String email){
        ResponseVO response;
        try{
            List<PostPO> postPOList = postMapper.selectOrderByEmail(email);
            if (postPOList.size()!=0){
                response = ResponseVO.buildSuccess(postPOList);
                response.setMessage("获取订单成功");
            }else {
                response = ResponseVO.buildFailure(null);
                response.setMessage("获取订单失败，原因：该用户无接单");
            }
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("获取订单失败，未知原因");
            return response;
        }
    }

    public ResponseVO delPost(int postId){
        ResponseVO response;
        try{
            if (postMapper.delPostById(postId)){
                response = ResponseVO.buildSuccess(null);
                response.setMessage("删帖成功");
            }else {
                response = ResponseVO.buildFailure(null);
                response.setMessage("删帖失败，原因：订单不存在或已被接单");
            }
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response=ResponseVO.buildFailure(null);
            response.setContent("删帖失败，未知原因");
            return response;
        }
    }


}
