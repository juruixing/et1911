package com.etoak;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.etoak.action.UserAction;
import com.etoak.bean.User;
import com.etoak.config.UserConfig;

public class ConfigTest {

	public static void main(String[] args) {
		ApplicationContext ac = new 
				AnnotationConfigApplicationContext(UserConfig.class);
		UserAction userAction = ac.getBean(UserAction.class);
		System.out.println(userAction);
		User user = userAction.getById(200);
		System.out.println(user.getId()+":"+user.getName());
	}

}
