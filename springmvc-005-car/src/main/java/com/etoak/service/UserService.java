package com.etoak.service;

import com.etoak.bean.User;

public interface UserService {
	User getUserById(int id);
	User getByNameAndPassword(String name,String password);
}
