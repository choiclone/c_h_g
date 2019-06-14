package com.spring.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.user.User;
import com.spring.user.UserDAO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDao;

	// 회원가입
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		return "user/signUp";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(User user) throws Exception {
		userDao.insert(user);
		return "user/welcome";
	}

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String email, String passwd, HttpSession session) throws Exception {
		User loginUser = userDao.login(email, passwd);
		if (loginUser != null) {
			session.setAttribute("check", loginUser);
			return "user/changePasswd";
		} else {
			return "user/login";
		}
	}

	// 회원변경ㅋ
	@RequestMapping(value = "/editAccount", method = RequestMethod.GET)
	public String editAccount() {
		return "user/editAccount";
	}

	@RequestMapping(value = "/editAccount", method = RequestMethod.POST)
	public String editAccount(User user, HttpSession session) throws Exception {
		User loginUser = (User) session.getAttribute("check");
		String email = loginUser.getEmail(); // 세션에 저장된 사용자 정보로부터 이메일을 알아낸다.

		if (user.getName() == null) {
			user.setName(loginUser.getName());
		}
		if (user.getMobile() == null) {
			user.setMobile(loginUser.getMobile());
		}

		user.setEmail(email);
		int check = userDao.modify(user);
		if (check == 1) {
			session.setAttribute("check", user);
		}

		return "user/changePasswd";

	}

	// 비밀번호 변경
	@RequestMapping(value = "/changePasswd", method = RequestMethod.GET)
	public String changePasswd() {
		return "user/changePasswd";
	}

	@RequestMapping(value = "/changePasswd", method = RequestMethod.POST)
	public String changePasswd(String passwd, HttpSession session) throws Exception {
		String email = ((User) session.getAttribute("check")).getEmail();

		User user = new User();
		user.setEmail(email);
		user.setPasswd(passwd);

		userDao.changePasswd(user);

		return "user/confirm";
	}

	// 회원 삭제
	@RequestMapping(value = "/bye", method = RequestMethod.GET)
	public String bye(HttpSession session) {
		User user = (User) session.getAttribute("check");
		userDao.d_Member(user);
		session.invalidate();

		return "user/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("check");

		return "user/login";

	}
}
