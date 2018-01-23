package com.criller.base.controller;

import java.util.List;

import javax.annotation.Resource;

import com.criller.base.core.Result;
import com.criller.base.core.ResultGenerator;
import com.criller.base.domain.User;
import com.criller.base.mapper.UserMapper;
import com.criller.base.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * @description:
 * @author: CaoCheng
 * @date: Created in 09:53 2018/1/22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = { "selectById" }, method = RequestMethod.GET)
    public User selectById(@RequestParam("id") int id) {
        return userService.selectById(id);
    }

    /**
     * 用户分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = { "selectByPage" }, method = RequestMethod.GET)
    public PageInfo selectByPage(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> users = userService.findAll();
        PageInfo pageInfo = new PageInfo(users);
        return pageInfo;
    }

    /**
     * 新增用户
     *
     * @param user 用户对象
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody User user) {
        int id = userMapper.insert(user);
        return ResultGenerator.genSuccessResult(id);
    }
}
