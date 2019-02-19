package com.qzing.singlehouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qzing.singlehouse.common.model.User;
@Mapper
public interface UserMapper {
	
	//获取所有用户
	public List<User> selectUsers();

}
