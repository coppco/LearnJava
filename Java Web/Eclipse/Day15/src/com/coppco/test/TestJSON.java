package com.coppco.test;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.coppco.domain.User;

public class TestJSON {
	@Test
	public void test() {
		User user = new User("张三", "1234");
		String json = JSON.toJSONString(user);
		
		System.out.println(json);
	}
}
