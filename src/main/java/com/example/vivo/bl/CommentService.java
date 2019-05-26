package com.example.vivo.bl;

import com.example.vivo.vo.ReplyForm;
import com.example.vivo.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommentService {

    ResponseVO replyPost(ReplyForm replyForm);

    ResponseVO getCommentsByPostId(int postId);

    ResponseVO getNews(String email);

}
