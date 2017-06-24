package com.niit.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.ecommerce.dao.CartDAO;
import com.niit.ecommerce.dao.CustomerDAO;
import com.niit.ecommerce.domain.Cart;
import com.niit.ecommerce.domain.Customer;

@Controller
public class CartController {

	@Autowired
	CustomerDAO cdao;

	@Autowired
	CartDAO cartdao;

	@RequestMapping("/cart/getCartId")
	public String getCartId(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Customer customer = cdao.getCustomerByUsername(username);
		model.addAttribute("cartId", customer.getCart().getCartId());
		return "cart";
	}

	// get cart
	@RequestMapping("/cart/getCart/{cartId}")
	public @ResponseBody Cart getCartItems(@PathVariable(value = "cartId") int cartId) {
		return cartdao.getCartByCartId(cartId);
	}
}
