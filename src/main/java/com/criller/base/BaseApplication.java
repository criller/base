package com.criller.base;

import java.util.Properties;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author caocheng
 * @ServletComponentScan 设置启动时spring能够扫描到我们自己编写的servlet和filter, 用于Druid监控
 * @date 2018-01-18
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan({ "com.criller.base.mapper"})
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        //配置mysql数据库的方言
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
