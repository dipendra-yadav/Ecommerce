package com.niit.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.UserDAO;
import com.niit.ecommerce.domain.User;

@Controller
public class HomeController {

	@Autowired
	HttpSession session;

	@Autowired
	User user;

	@Autowired
	UserDAO userDAO;

	@RequestMapping("/")
	public ModelAndView showHomePage() {
		System.out.println("check");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("msg", "Welcome to Yuzu");
		return mv;
	}

	/*
	 * @RequestMapping("/logout") public ModelAndView logout() {
	 * System.out.println("check5"); ModelAndView mv = new
	 * ModelAndView("/home");
	 * 
	 * session.removeAttribute("loginMessage");
	 * 
	 * return mv; }
	 */
	@RequestMapping("/adminHome")
	public ModelAndView showAdminHome() {
		ModelAndView mv = new ModelAndView("/adminHome");
		return mv;
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

}
