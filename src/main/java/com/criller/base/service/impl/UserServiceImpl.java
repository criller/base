package com.criller.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.criller.base.core.BaseException;
import com.criller.base.domain.User;
import com.criller.base.enums.BaseEnum;
import com.criller.base.mapper.UserMapper;
import com.criller.base.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: CaoCheng
 * @description:
 * @date: Created in 15:00 2018/1/22
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public User selectById(int id) {
        return userMapper.selectById(id);
    }
}
