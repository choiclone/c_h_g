package com.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDAO userDAOImpl;

	
	public int insert(User user) throws Exception {
		return userDAOImpl.insert(user);
	}

	
	public User login(String email, String passwd) {
		// TODO Auto-generated method stub
		return userDAOImpl.login(email, passwd);
	}


	public int modify(User user) {
		// TODO Auto-generated method stub
		return userDAOImpl.modify(user);
	}


	public void changePasswd(User user) {
		// TODO Auto-generated method stub
		userDAOImpl.changePasswd(user);
	}


	public void d_Member(User user) {
		// TODO Auto-generated method stub
		userDAOImpl.d_Member(user);
	}

}
