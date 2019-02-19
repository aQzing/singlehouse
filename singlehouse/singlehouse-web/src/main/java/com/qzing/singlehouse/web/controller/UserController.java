package com.qzing.singlehouse.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qzing.singlehouse.common.model.User;
import com.qzing.singlehouse.common.result.ResultMsg;
import com.qzing.singlehouse.service.UserService;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 注册提交：1.注册验证 2.发送邮件 3.验证失败重定向
	 * 注册页面：根据account判断是否是注册页获取请求
	 * @param account
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("accounts/register")
	public String accountsRegister(User account,ModelMap modelMap) {
		if(account==null||account.getName()==null) {
			return "/user/accounts/register";
		}
		//验证用户填写信息
		ResultMsg resultMsg = UserHelper.validate(account);
		if(resultMsg.isSuccess()&&userService.addAccount(account)) {
			return "user/accounts/registerSubmit";
		}else{
			return "redirect:user/accounts/register?"+resultMsg.asUrlParams();
		}
	}

}
