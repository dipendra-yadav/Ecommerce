package com.niit.ecommerce.dao;

import java.io.IOException;

import com.niit.ecommerce.domain.Cart;

public interface CartDAO {

	Cart getCartByCartId(int cartId);

	Cart validate(int cartId) throws IOException;

	//void update(Cart cart);
}
