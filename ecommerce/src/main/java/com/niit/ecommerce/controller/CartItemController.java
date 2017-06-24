package com.niit.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.ecommerce.dao.CartDAO;
import com.niit.ecommerce.dao.CartItemDAO;
import com.niit.ecommerce.dao.CustomerDAO;
import com.niit.ecommerce.dao.ProductDAO;
import com.niit.ecommerce.domain.Cart;
import com.niit.ecommerce.domain.CartItem;
import com.niit.ecommerce.domain.Customer;
import com.niit.ecommerce.domain.Product;

@Controller
public class CartItemController {

	@Autowired
	CustomerDAO cdao;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CartItemDAO cartItemdao;

	@Autowired
	CartDAO cartdao;

	@RequestMapping("/cart/add/{productId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addCartItem(@PathVariable(value = "productId") int productId) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Customer customer = cdao.getCustomerByUsername(username);
		Cart cart = customer.getCart();
		List<CartItem> cartItems = cart.getCartItems();

		Product product = productDAO.getProductByID(productId);
		for (int i = 0; i < cartItems.size(); i++) {
			CartItem cartItem = cartItems.get(i);
			if (product.getId() == cartItem.getProduct().getId()) {
				cartItem.setQuantity(cartItem.getQuantity() + 1);// increment
																	// the
																	// quantity
				cartItem.setTotalPrice(cartItem.getQuantity() * product.getPrice());// update
																					// the
																					// total
																					// price
				cartItemdao.addCartItem(cartItem);// update the quantity in the
													// cartitem

				return;
			}

		}

		CartItem cartItem = new CartItem();
		cartItem.setQuantity(1);
		cartItem.setProduct(product);// set product id
		cartItem.setTotalPrice(product.getPrice() * 1);
		cartItem.setCart(cart);// set cart id
		cartItemdao.addCartItem(cartItem);// insert query

		// model.addAttribute("cart", cart);

		// return "cart";

	}

	@RequestMapping("/cart/removecartitem/{cartItemId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable(value = "cartItemId") int cartItemId) {
		CartItem cartItem = cartItemdao.getCartItem(cartItemId);
		cartItemdao.removeCartItem(cartItem);
	}

	@RequestMapping("/cart/removeAllItems/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeAllCartItem(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartdao.getCartByCartId(cartId);
		cartItemdao.removeAllCartItems(cart);
	}
}
