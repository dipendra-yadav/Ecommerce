package com.niit.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ecommerce.dao.CartDAO;
import com.niit.ecommerce.dao.CustomerOrderDAO;
import com.niit.ecommerce.domain.Cart;
import com.niit.ecommerce.domain.Customer;
import com.niit.ecommerce.domain.CustomerOrder;

@Controller
public class OrderController {

	@Autowired
	CartDAO cartdao;

	@Autowired
	CustomerOrderDAO custOrderDao;

	@Autowired
	CustomerOrder customerOrder;

	@RequestMapping(value = "/order/{cartId}")
	public String createOrder(@PathVariable("cartId") int cartId) {

		/*System.out.println("1**");
		// customerOrder = new CustomerOrder();
		Cart cart = cartdao.getCartByCartId(cartId);

		// UPDATE CARTID FOR CUSTOMERORDER - SET CARTID
		customerOrder.setCart(cart);

		System.out.println("2**");
		Customer customer = cart.getCustomer();
		System.out.println(customer.toString());
		// SET CUSTOMERID
		customerOrder.setCustomer(customer);
		System.out.println("3**");
		// SET BILLINGADDRESSID
		customerOrder.setBillingAddress(customer.getBillingAddress());
		System.out.println("4");
		// SET SHIPPINGADDRESSID
		customerOrder.setShippingAddress(customer.getShippingAddress());
		System.out.println("5");

		custOrderDao.addCustomerOrder(customerOrder);
		System.out.println("6");
*/
		return "redirect:/checkout?cartId=" + cartId;

	}

}
