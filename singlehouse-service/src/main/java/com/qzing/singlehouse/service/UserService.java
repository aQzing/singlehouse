package com.qzing.singlehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzing.singlehouse.common.model.User;
import com.qzing.singlehouse.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	public List<User> getUsers() {
		return userMapper.selectUsers();
	}

}
