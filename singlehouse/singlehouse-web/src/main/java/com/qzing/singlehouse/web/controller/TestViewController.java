package com.qzing.singlehouse.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qzing.singlehouse.common.model.User;
import com.qzing.singlehouse.service.UserService;

@Controller
public class TestViewController {
	@Autowired
	private UserService userService;
	@RequestMapping("hello")
 public String getView(ModelMap modelMap) {
		List<User> users = userService.getUsers();
		modelMap.put("user", users.get(0));
	 return "hello";
 }
}
