package com.etoak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.Student;

/*
 * 测试java bean接收参数
 * 测试数组接收参数
 * 测试list接收参数
 * 测试map接收参数
 * */
@Controller
@RequestMapping("/complex")
public class ComplexController {
	//Get请求 ：@RequestMapping的method属性指定
	//@GetMapping
	@GetMapping("/bean")
	public String bean(Student student,Model model) {
		System.out.println(student);
		model.addAttribute("result2", "使用Model传值");
		return "forward:/simple/simple?id=111";
	}
	//测试数组传参
	@PostMapping("/array")
	public String array(String[] hobby,ModelMap modelMap) {
		for(String hobbyStr : hobby) {
			System.out.println("hobby - " + hobbyStr);
		}
		modelMap.addAttribute("result", "使用ModelMap传参");
		return "param";
	}
	
	//第五种:测试List传参(List封装到java bean当中)
	//第五种向request域传值的方式:使用Map
	//当以表单的方式传递参数的时候，不能把list写到controller方法的方法参数上，
	//应该写到一个java bean中
	//只有当传递的参数是json数组时，可以将list写到controller方法参数上
	@PostMapping("/list")
	public String list(Student student,Map<String,Object> map) {
		List<String> hobbyList = student.getHobbyList();
		if(!CollectionUtils.isEmpty(hobbyList)) {
			hobbyList.forEach(x -> System.out.println(x));
		}
		map.put("result","使用Map传值");
		return "param";
	}

	//第六种接收参数方式map
	@PostMapping(value = "/map",produces = {"text/plain"})
	@ResponseBody
	public String map(Student student) {
		System.out.println(student.getStuMap());
		return "success";
	}

}
