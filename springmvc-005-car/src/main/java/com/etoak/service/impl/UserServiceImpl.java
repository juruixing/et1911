package com.etoak.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.User;
import com.etoak.mapper.UserMapper;
import com.etoak.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	UserMapper userMapper;
	@Override
	public User getUserById(int id) {
		return userMapper.getUserById(id);
	}
	@Override
	public User getByNameAndPassword(String name, String password) {
		return userMapper.getByNameAndPassword(name, password);
	}

}
