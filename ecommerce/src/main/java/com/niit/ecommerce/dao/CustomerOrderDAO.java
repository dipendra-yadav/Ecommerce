package com.niit.ecommerce.dao;

import com.niit.ecommerce.domain.CustomerOrder;

public interface CustomerOrderDAO {

	void addCustomerOrder(CustomerOrder customerOrder);

	public double getCustomerOrderGrandTotal(int cartId);
}
