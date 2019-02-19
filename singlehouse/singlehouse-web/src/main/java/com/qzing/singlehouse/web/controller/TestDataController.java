package com.qzing.singlehouse.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qzing.singlehouse.common.model.User;
import com.qzing.singlehouse.service.UserService;

@RestController
public class TestDataController {
	@Autowired
	private UserService userService;
	@RequestMapping("testDate")
	public List<User>getUsers(){
		
		return userService.getUsers();
	}
}
