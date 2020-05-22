package com.etoak.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		request.setAttribute("user",
				new User(1,"requestUser","",20));
		request.getSession().setAttribute("sessionUser",
				new User(2,"sessionUser","",30));
		//用于测试thymeleaf遍历List
		List<User> userList = new ArrayList<>();
		request.setAttribute("userList",userList);
		userList.add(new User(3,"李白","",45));
		userList.add(new User(4,"杜甫","",80));
		return "index";
	}
	@RequestMapping("/add")
	public String add(String name) {
		System.out.println(name);
		return "forward:/index";
	}
	@RequestMapping("/json")
	@ResponseBody
	public String json(@RequestBody Map<String,String> map) {
		System.out.println(map);
		return "success";
	}
}
