package com.example.vivo.bl;

import com.example.vivo.vo.ReplyForm;
import com.example.vivo.vo.ResponseVO;

public interface CommentService {

    ResponseVO replyPost(ReplyForm replyForm);

    ResponseVO getCommentsByPostId(int postId);


}
