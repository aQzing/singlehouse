package com.qzing.singlehouse.web.controller;

import org.apache.logging.log4j.util.Strings;

import com.qzing.singlehouse.common.model.User;
import com.qzing.singlehouse.common.result.ResultMsg;

public class UserHelper {
	/**
	 * 验证注册信息是否正确
	 * @param user
	 * @return
	 */
	public static ResultMsg validate(User account) {
		if(Strings.isBlank(account.getName())) {
			return ResultMsg.errorMsg("用户名不能为空");
		}
		if(Strings.isBlank(account.getEmail())) {
			return ResultMsg.errorMsg("邮箱不能为空");
		}
		if(Strings.isBlank(account.getPasswd())||Strings.isBlank(account.getConfirmPasswd())) {
			return ResultMsg.errorMsg("密码不能为空");
		}
		if(account.getPasswd().length()<6) {
			return ResultMsg.errorMsg("密码不能小于6位数");
		}
		return ResultMsg.successMsg("");
	}
}
