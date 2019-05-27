package com.example.vivo.blImpl;

import com.example.vivo.po.CommentPO;

import java.util.List;

public interface PostServiceForBL {

    boolean addComment(int postId, int commentId);

    List<String> getCommentIdsByPostId(int postId);

}
