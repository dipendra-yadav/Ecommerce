package com.niit.ecommerce.controller;
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.CategoryDAO;
import com.niit.ecommerce.dao.ProductDAO;
import com.niit.ecommerce.dao.SupplierDAO;
import com.niit.ecommerce.domain.Category;
import com.niit.ecommerce.domain.Product;
import com.niit.ecommerce.domain.Supplier;

@Controller
public class AdminController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;

	@RequestMapping("/manage_categories")
	public ModelAndView manageCategories() {
		System.out.println("manageCategories");
		ModelAndView mv = new ModelAndView("adminHome");
		mv.addObject("isUserClickedCategories", "true");

		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		mv.addObject("category", category);
		return mv;

	}

	@RequestMapping("/manage_products")
	public ModelAndView manageProducts() {
		System.out.println("manageProducts");
		ModelAndView mv = new ModelAndView("adminHome");
		mv.addObject("isUserClickedProducts", "true");
		List<Product> productList = productDAO.list();
		mv.addObject("productList", productList);
		mv.addObject("product", product);

		return mv;
	}

	@RequestMapping("/manage_suppliers")
	public ModelAndView manageSuppliers() {
		System.out.println("manageSupplier");
		ModelAndView mv = new ModelAndView("adminHome");
		mv.addObject("isUserClickedSuppliers", "true");
		List<Supplier> supplierList = supplierDAO.list();
		mv.addObject("supplierList", supplierList);
		mv.addObject("supplier", supplier);
		return mv;

	}

}
