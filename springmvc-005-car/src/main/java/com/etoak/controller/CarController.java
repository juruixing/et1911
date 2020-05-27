package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.exception.ParamException;
import com.etoak.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
	@Autowired
	CarService carService;
	
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "car/add";
	}
	
	@RequestMapping("/toList")
	public String toList() {
		return "car/list";
	}
	
	@RequestMapping("/add")
	public String add(MultipartFile file,@Valid Car car,BindingResult bindingResult,
			HttpServletRequest request) throws IllegalStateException, IOException {
		String originalFilename = file.getOriginalFilename();
		log.info("文件名称 - {}",originalFilename);
		log.info("car - {}",car);
		//先校验Car
		List<ObjectError> allErrors = bindingResult.getAllErrors();
		if(!CollectionUtils.isEmpty(allErrors)) {
			//String每次遍历需要创建对象，StringBuffer不需要
			StringBuffer errorBuf = new StringBuffer();
			for(ObjectError error : allErrors) {
				String errorMsg = error.getDefaultMessage();
				errorBuf.append(errorMsg).append(";");
			}
			//request.setAttribute("paramError",errorBuf.toString());
			//return "forward:/car/toAdd";
			throw new ParamException(errorBuf.toString());
		}
		//新文件名称
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String newFileName = uuid + "_" + originalFilename;
		//目标文件
		File destFile = new File("d:/upload",newFileName);
		//图片上传到目标文件
		file.transferTo(destFile);
		car.setPic("/pic/" +newFileName);
		carService.addCar(car);
		return "redirect:/car/toAdd";
	}
	
	@GetMapping("/list")
	@ResponseBody
	public PageVo<CarVo> queryList(
			@RequestParam(required = false,defaultValue = "1") int pageNum,
			@RequestParam(required = false,defaultValue = "8") int pageSize,
			CarVo carVo,
			String[] priceList){
		return carService.queryList(pageNum, pageSize, carVo,priceList);
	}
	
	//查询所有品牌
	@GetMapping("/getBrand")
	@ResponseBody
	public List<String> getBrand(){
		return carService.getAllBrand();
	}
	
	//根据品牌查询车系，如果品牌为空随机查询十个
	@GetMapping("/getSeries")
	@ResponseBody
	public List<String> getSeries(String brand){
		return carService.getSeriesByBrand(brand);
	}

}
