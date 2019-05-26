package com.example.vivo.data.post;

import com.example.vivo.po.PostPO;
import com.example.vivo.vo.PostForm;
import com.example.vivo.vo.PostsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PostMapper {
    /*
    * 首页展示所有post
    * @return
    * */
    List<PostPO> selectPostsByTime();

    /*
    * 增加post订单
    * */
//     addPost(PostForm postForm);

    /*
    * 更新订单状态；默认未接单；0为被接单；1为接单后放弃；2为已完成
    * */
    //updatePostTaker(orderForm,0)

    /*
    * 完成订单
    * */
    //completePost(String postId)



    /*
    * 按照major展示订单
    * */
   List<PostPO> selectPostsByMajor( int major);

}
