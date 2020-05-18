package com.etoak.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etoak.action.UserAction;
import com.etoak.service.UserService;

/*
 * 注解@Configuration相当于xml的根元素<beans>标签
 * 表示这是一个spring IOC容器
 * */
@Configuration   
public class UserConfig {
	//注册spring bean使用@Bean
	//返回类型相当于bean标签的class属性
	//方法名可以认为是bean标签的id属性
	@Bean("userService")
	public UserService userService() {
		return new UserService();
	}
	@Bean("userAction")
	public UserAction userAction(
			@Qualifier("userService")
			UserService userService) {
		UserAction userAction = new UserAction();
		userAction.setUserService(userService);
		return userAction;
	}
}
