package com.niit.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.CustomerDAO;
import com.niit.ecommerce.domain.BillingAddress;
import com.niit.ecommerce.domain.Customer;
import com.niit.ecommerce.domain.ShippingAddress;
import com.niit.ecommerce.domain.User;

@Controller
public class RegistrationController {

	
	@Autowired
	CustomerDAO cdao;

	
	
	// To display registration form
	@RequestMapping(value = "/customer/registration", method = RequestMethod.GET)
	public ModelAndView getRegistrationForm() {
		Customer customer = new Customer();
		User user = new User();
		
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();

		customer.setUser(user);
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		return new ModelAndView("registrationCustomer", "customer", customer);

	}

	// to insert the data
	@RequestMapping(value = "/customer/registration", method = RequestMethod.POST)
	public String registerCustomer(@Valid @ModelAttribute(value = "customer") Customer customer, BindingResult result,
			Model model) {
		if (result.hasErrors())
			return "registrationCustomer";

		/*List<Customer> customerList = cdao.getAllCustomers();
		for (Customer c : customerList) {
			if (c.getUsers().getUsername().equals(customer.getUsers().getUsername())) {
				model.addAttribute("duplicateUname", "Username already exists");
				return "registrationCustomer";
			}
			if (c.getCustomerEmail().equals(customer.getCustomerEmail())) {
				model.addAttribute("duplicateEmail", "Email Id is invalid or already exists!");
				return "registrationCustomer";
			}
		}
		
		*/
		
		

		cdao.addCustomer(customer);
		model.addAttribute("registration success", "Registered Successfully. Login using username and password");
		return "login";
	}

}
