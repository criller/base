package com.criller.base.mapper;

import java.util.Date;
import java.util.List;

import com.criller.base.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: CaoCheng
 * @description: User映射类
 * @date: Created in 10:04 2018/1/19
 */
public interface UserMapper {
    /**
     * 新增user
     *
     * @param user 用户对象
     * @return
     */
    @Insert("INSERT INTO USER(NAME, PASSWORD, EMAIL,STATUS) VALUES(#{user.name}, #{user.password}, #{user.email},#{user.status})")
    int insert(User user);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User selectById(@Param("id") int id);

    /**
     * 查询所有记录
     *
     * @return
     */
    @Select("select * from user")
    List<User> selectAll();
}
