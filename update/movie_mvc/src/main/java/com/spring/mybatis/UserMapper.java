package com.spring.mybatis;

import org.apache.ibatis.annotations.Param;

import com.spring.user.User;

public interface UserMapper {
	public int insert(User user);

	public User login(@Param("email")String email,@Param("passwd")String passwd);

	public int modify(User user);

	public void changePasswd(User user);

	public void d_Member(User user);
}
