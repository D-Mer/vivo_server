package com.example.vivo.blImpl;

import com.example.vivo.bl.CommentService;
import com.example.vivo.data.comment.CommentMapper;
import com.example.vivo.po.CommentPO;
import com.example.vivo.vo.CommentVO;
import com.example.vivo.vo.ReplyForm;
import com.example.vivo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    FileServiceForBL fileService;

    @Autowired
    PostServiceForBL postService;

    @Override
    public ResponseVO replyPost(ReplyForm replyForm) {
        ResponseVO response;
        try {
            StringBuilder url = new StringBuilder();
            String tempUrl;
            CommentPO commentPO;
            for (MultipartFile f : replyForm.getPictures()) {
                if ((tempUrl = String.valueOf(fileService.saveFile(f, replyForm.getEmail()).getContent())).equals("null")) {
                    response = ResponseVO.buildFailure(null);
                    response.setMessage("回帖失败，原因：文件保存失败");
                    return response;
                }
                url.append(url.length() == 0 ? tempUrl : "," + tempUrl);
            }
            commentPO = new CommentPO(replyForm, url.toString());
            commentMapper.insertComment(commentPO);
            commentPO.setId(commentMapper.selectLastCommentId());
            if (postService.addComment(commentPO.getPostId(), commentPO.getId())){
                response = ResponseVO.buildSuccess(Arrays.asList(url.toString().split(",")));
                response.setMessage("回帖成功");
            }else {
                response = ResponseVO.buildFailure(null);
                response.setMessage("回帖失败，插入回帖数据时出错");
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setContent("回帖失败，发生了未知错误");
            return response;
        }
    }

    @Override
    public ResponseVO getCommentsByPostId(int postId) {
        ResponseVO response;
        try{
            List<CommentVO> commentVOList = new ArrayList<>();
            List<String> idStrings = postService.getCommentIdsByPostId(postId);
            int id;
            for (String s : idStrings) {
                id = Integer.parseInt(s);
                commentVOList.add(new CommentVO(commentMapper.selectCommentById(id)));
            }
            response = ResponseVO.buildSuccess(sort(commentVOList));
            response.setMessage("获取评论成功");
        }catch (Exception e){
            e.printStackTrace();
            response = ResponseVO.buildFailure(null);
            response.setMessage("获取评论失败，原因：评论或帖子不存在");
        }
        return response;
    }

    private List<List<CommentVO>> sort(List<CommentVO> commentVOList){
        List<List<CommentVO>> resultList = new ArrayList<>();
        List<CommentVO> outerList = new ArrayList<>();
        List<CommentVO> innerList = new ArrayList<>();
        for (CommentVO vo : commentVOList) {
            if (vo.getFirstCommentId()==0 && vo.getSecondCommentId()==0){
                outerList.add(vo);
            }else {
                innerList.add(vo);
            }
        }
        List<CommentVO> tempList;
        for (CommentVO commentVO : outerList) {
            tempList = new ArrayList<>();
            tempList.add(commentVO);
            for (CommentVO comment : innerList) {
                if (comment.getFirstCommentId() == commentVO.getId()) {
                    tempList.add(comment);
                }
            }
            resultList.add(tempList);
        }

        return resultList;
    }

}
