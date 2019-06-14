package com.spring.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.board.BoardService;
import com.spring.board.BoardVo;

@Controller
public class MainController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/main")
	public String Main(BoardVo Bv, Model model) {
		return "main";
	}
	
//	@RequestMapping(value = "/main", method = RequestMethod.GET)
//	public String listPage(@ModelAttribute("p") Paging p, Model model) throws Exception {
//		model.addAttribute("list", service.list(p));
//		PageMaker pm = new PageMaker();
//		pm.setP(p);
//		pm.setTotalCount(service.countPaging(p));
//		
//		model.addAttribute("pm", pm);
//		return "/main";
//	}
}
