package com.niit.ecommerce.dao;

import com.niit.ecommerce.domain.Cart;
import com.niit.ecommerce.domain.CartItem;

public interface CartItemDAO {

	void addCartItem(CartItem cartItem);

	void removeCartItem(CartItem cartItemId);

	void removeAllCartItems(Cart cart);

	CartItem getCartItem(int cartItemId);
}
