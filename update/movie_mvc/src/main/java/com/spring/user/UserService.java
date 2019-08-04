package com.spring.user;

public interface UserService {
	public int insert(User user) throws Exception;

	public User login(String email, String passwd);

	public int modify(User user);

	public void changePasswd(User user);

	public void d_Member(User user);
}
