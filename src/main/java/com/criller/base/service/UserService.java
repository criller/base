package com.criller.base.service;

import java.util.List;

import com.criller.base.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: CaoCheng
 * @description:
 * @date: Created in 14:59 2018/1/22
 */
public interface UserService {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID查询一条记录
     *
     * @param id
     * @return
     */
    User selectById(int id);
}
