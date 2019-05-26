package com.example.vivo.data.post;

import com.example.vivo.po.PostPO;
import com.example.vivo.vo.OrderForm;
import com.example.vivo.vo.PostForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface PostMapper {
    /*
    * 首页展示所有post
    * @return
    * */
    List<PostPO> selectPostsByTime();

    /*
     * 展示指定id的post
     * @return
     * */
    PostPO selectPostById(int id);

    /*
    * 增加post订单
    * */
    boolean addPost(PostPO postPO);

    /*
     * 接受post订单
     * */
    boolean takeOrder(int postId, String email);

    /*
    * 更新订单状态；默认为0，未接单；1为被接单；2为已完成
    * */
    boolean giveUpPost(int postId);

    /*
    * 完成订单
    * */
    boolean completePost(String postId, Date endTime);


    /*
    * 按照major展示订单
    * */
   List<PostPO> selectPostsByMajor( int major);

   /*
   * 删除订单
   * */
   boolean delPostById(int postId);
}
