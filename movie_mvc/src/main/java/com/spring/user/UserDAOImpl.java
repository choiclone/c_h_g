package com.spring.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mybatis.UserMapper;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession sqlSession;

	public int insert(User user) throws Exception{
		// TODO Auto-generated method stub
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		return userMapper.insert(user);
	}

	public User login(String email, String passwd) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.login(email, passwd);
	}

	public int modify(User user) {
		// TODO Auto-generated method stub
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		return userMapper.modify(user);
	}

	public void changePasswd(User user) {
		// TODO Auto-generated method stub
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.changePasswd(user);
	}

	public void d_Member(User user) {
		// TODO Auto-generated method stub
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.d_Member(user);
	}

}
