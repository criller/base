package com.criller.base.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.criller.base.core.BaseException;
import com.criller.base.core.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 统一异常处理
 *
 * @author: CaoCheng
 * @description:
 * @date: Created in 23:06 2018/1/22
 */
@Configuration
public class WebMvcConfigure extends WebMvcConfigurerAdapter {
    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigure.class);

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add((request, response, handler, e) -> {
            Result result = new Result();
            if (e instanceof BaseException) {
                // 业务失败的异常，如“账号或密码错误”
                result.setMessage(e.getMessage());
                result.setCode(((BaseException) e).getCode());
                logger.error(e.getMessage());
            } else {
                result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                result.setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
                String message;
                if (handler instanceof HandlerMethod) {
                    HandlerMethod handlerMethod = (HandlerMethod) handler;
                    message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s", request.getRequestURI(), handlerMethod.getBean().getClass().getName(),
                            handlerMethod.getMethod().getName(), e.getMessage());
                } else {
                    message = e.getMessage();
                }
                logger.error(message, e);
            }
            responseResult(response, result);
            return new ModelAndView();
        });
    }

    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}
