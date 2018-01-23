package com.criller.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: CaoCheng
 * @description:
 * @date: Created in 09:25 2018/1/19
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }
}
