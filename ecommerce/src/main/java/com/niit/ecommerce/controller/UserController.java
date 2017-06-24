package com.niit.ecommerce.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.CategoryDAO;
import com.niit.ecommerce.dao.ProductDAO;
import com.niit.ecommerce.dao.SupplierDAO;
import com.niit.ecommerce.dao.UserDAO;
import com.niit.ecommerce.domain.Category;
import com.niit.ecommerce.domain.Product;
import com.niit.ecommerce.domain.Supplier;
import com.niit.ecommerce.domain.User;

@Controller
public class UserController {

	@Autowired
	HttpSession session;

	@Autowired
	User user;

	@Autowired
	UserDAO userDAO;

	@Autowired
	private Category category;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Product product;
	@Autowired
	private ProductDAO productDAO;

	// To display registration form
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getRegistrationForm() {
		ModelAndView mv = new ModelAndView("/register");
		mv.addObject("isUserClickedRegister", "true");
		mv.addObject("user", user);
		return mv;

	}

	// To post registration form
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegistraton(@Valid @ModelAttribute(value = "user") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "register";
		}
		model.addAttribute("registrationSuccessMessage", "Registered Successfully. Login using username and password");
		model.addAttribute("userObject", user);

		userDAO.save(user);
		return "login";

	}

	/*
	 * // SHOW login page
	 * 
	 * @RequestMapping(value = "/Login", method = RequestMethod.GET) public
	 * ModelAndView showLoginPage() {
	 * System.out.println("showLoginPage called***"); ModelAndView mv = new
	 * ModelAndView("/login"); mv.addObject("isUserClickedLogin", "true"); //
	 * mv.addObject("userObject", user);
	 * 
	 * return mv; }
	 * 
	 * 
	 */

	// authentication/validation

	/*
	 * @RequestMapping(value = "validate", method = RequestMethod.POST) public
	 * ModelAndView validateCredentials(@Valid @ModelAttribute(value =
	 * "userObject") User user, BindingResult result, Model model) {
	 * 
	 * System.out.println("validateCredentials called********************");
	 * ModelAndView mv = new ModelAndView("login");
	 * mv.addObject("isUserLoggedIn", "false"); if (result.hasErrors()) return
	 * mv;
	 * 
	 * if (userDAO.validate(user.getName(), user.getPassword())) { // Make
	 * userloogedIn as True mv.addObject("isUserLoggedIn", "true");
	 * 
	 * // add session attributes session.setAttribute("loggedInUser",
	 * user.getName()); session.setAttribute("user", user);
	 * 
	 * session.setAttribute("supplier", supplier);
	 * session.setAttribute("supplierList", supplierDAO.list());
	 * 
	 * session.setAttribute("productList", productDAO.list());
	 * session.setAttribute("product", product);
	 * 
	 * session.setAttribute("category", category);
	 * session.setAttribute("categoryList", categoryDAO.list());
	 * 
	 * // get the User user = userDAO.getUser(user.getName());
	 * 
	 * // checking the Role if (user.getRole().equals("ROLE_ADMIN")) { mv = new
	 * ModelAndView("adminHome"); mv.addObject("isAdmin", "true"); return mv;
	 * 
	 * } else { mv.addObject("isAdmin", "false"); mv = new ModelAndView("home");
	 * return mv; }
	 * 
	 * }
	 * 
	 * else { mv.addObject("invalidCredentials", "true");
	 * mv.addObject("errorMessage", "Invalid Credentials"); mv = new
	 * ModelAndView("login"); return mv; }
	 * 
	 * }
	 * 
	 */

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null)
			model.addAttribute("error", "Invalid username and password... Please enter the correctly");
		if (logout != null)
			model.addAttribute("logout", "logout successfully");

		return "login";
	}

}
