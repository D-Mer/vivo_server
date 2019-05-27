package com.example.vivo.data.comment;

import com.example.vivo.po.CommentPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface CommentMapper {

    boolean insertComment(CommentPO commentPO);

    int selectLastCommentId();

    CommentPO selectCommentById(int id);

}
