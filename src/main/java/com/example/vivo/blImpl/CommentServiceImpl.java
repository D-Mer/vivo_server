package com.example.vivo.blImpl;

import com.example.vivo.bl.CommentService;
import com.example.vivo.data.comment.CommentMapper;
import com.example.vivo.po.CommentPO;
import com.example.vivo.po.PostPO;
import com.example.vivo.vo.ReplyForm;
import com.example.vivo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    FileServiceForBL fileService;

    @Override
    public ResponseVO replyPost(ReplyForm replyForm) {
        ResponseVO response;
        try {
            StringBuilder url = new StringBuilder();
            String tempUrl;
            CommentPO commentPO;
            for (MultipartFile f : replyForm.getPictures()) {
                if ((tempUrl = String.valueOf(fileService.saveFile(f, replyForm.getEmail()).getContent())).equals("null")){
                    response = ResponseVO.buildFailure(null);
                    response.setMessage("发帖失败，原因：文件保存失败");
                    return response;
                }
                url.append(url.length() == 0 ? tempUrl : ","+tempUrl);
            }
            commentPO = new PostPO(postForm, url.toString());
            postMapper.addPost(commentPO);
            response = ResponseVO.buildSuccess(Arrays.asList(url.toString().split(",")));
            response.setMessage("发帖成功");
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("发生了未知错误");
            return response;

        return null;
    }

    @Override
    public ResponseVO getCommentsByPostId(int postId) {
        return null;
    }

    @Override
    public ResponseVO getNews(String email) {
        return null;
    }
}
