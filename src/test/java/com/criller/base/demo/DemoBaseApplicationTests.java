package com.criller.base.demo;

import java.util.Date;

import javax.annotation.Resource;

import com.criller.base.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan({"com.criller.base.mapper"})
public class DemoBaseApplicationTests {
	@Resource
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	/**
	 * 测试事物管理
	 */
	@Test
	@Transactional
	public void  testTrans(){
		int a = 1/0;
	}

}
