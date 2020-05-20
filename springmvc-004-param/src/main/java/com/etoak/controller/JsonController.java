package com.etoak.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etoak.bean.Student;
import com.etoak.bean.User;
import com.etoak.vo.ResultVo;

@RestController //相当于@Controller和@ResponseBody（应用到所有方法上）
@RequestMapping("/json")
public class JsonController {
	@PostMapping(value = "/jsonToMap",produces = "application/json;charset=utf-8")
	public String jsonToMap(@RequestBody Map<String,Object> jsonMap) {
		System.out.println(jsonMap);
		return "{\"msg\":\"success\"}";
		// json --> "{"msg":"success"}"
	}
	@PostMapping("/jsonToList")
	public Map<String,Object> jsonToList(@RequestBody List<User> userList){
		userList.forEach(x -> System.out.println(x));
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("code",200);
		resultMap.put("msg","success");
		return resultMap;
	}
	/*
	 * json转成java bean 最常见的转换方式
	 * */
	@PostMapping("/jsonToBean")
	public ResultVo jsonToBean(
			@RequestBody Student student) {
		System.out.println(student);
		return new ResultVo(200,"success");
	}
	
}
