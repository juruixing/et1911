package com.etoak.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarVo extends Car{

	private String levelName;
	private String gearboxName;
	private String outputVolumeName;
	//传入SQL中条件
	@JsonIgnore //spring mvc在返回结果中不封装这个
	private List<Map<String,Integer>> priceMapList;
	@JsonIgnore
	private String vehicleAge;
	@JsonIgnore
	private Integer startYear;
	@JsonIgnore
	private Integer endYear;
}
