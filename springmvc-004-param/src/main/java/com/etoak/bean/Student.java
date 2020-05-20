package com.etoak.bean;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private List<String> hobbyList;
	private Map<String,Object> stuMap;
	/*
	 * public Integer getId() { return id; } public void setId(Integer id) { this.id
	 * = id; } public String getName() { return name; } public void setName(String
	 * name) { this.name = name; } public Integer getAge() { return age; } public
	 * void setAge(Integer age) { this.age = age; }
	 * 
	 * @Override public String toString() { return "Student [id=" + id + ", name=" +
	 * name + ", age=" + age + "]"; }
	 */
	
}
