package com.dqy.helpeachothers.mapper;

import com.dqy.helpeachothers.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    String tableName="user";
    @Select("select * from "+tableName)
    List<User> select();


    //查找是否重复
    List<User> selectRepeat(@Param("user") User user);

    //插入
    Integer insertAll(@Param("user") User user);

    //登录
    List<User> login(@Param("phone")String phone,@Param("password")String password);

    //更新头像
    Integer updateHeadImg(@Param("user")User user);
    //更新
    Integer update(@Param("user")User user);

    //根据id查找用户
    User selectById(@Param("id")Integer id);
}
