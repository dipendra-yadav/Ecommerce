package com.niit.ecommerce.controller;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.CategoryDAO;
import com.niit.ecommerce.dao.ProductDAO;
import com.niit.ecommerce.dao.SupplierDAO;
import com.niit.ecommerce.domain.Category;
import com.niit.ecommerce.domain.Product;
import com.niit.ecommerce.domain.Supplier;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;
	@Autowired(required = true)
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;

	@Autowired(required = true)
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;

	// browse all products including Angular JS
	@RequestMapping(value = "/getProductsList")
	public @ResponseBody List<Product> getProductsListInJSON() {
		System.out.println("getProductsListInJSON called**************");
		return productDAO.list();
	}

	@RequestMapping(value = "/getAllProducts")
	public ModelAndView getAllProducts() {
		List<Product> allproducts = productDAO.list();
		ModelAndView mv = new ModelAndView("product", "productList", allproducts);
		return mv;
	}

	// add Product
	// method 1 for add Product
	@RequestMapping("/manage_product_create")
	public ModelAndView createProductForm() {
		System.out.println("createProductForm called*****************");
		ModelAndView mv = new ModelAndView("createProductForm");
		mv.addObject("createProductObj", product);
		mv.addObject("productList", this.productDAO.list());
		mv.addObject("category", new Category());
		mv.addObject("categoryList", this.categoryDAO.list());
		mv.addObject("supplier", new Supplier());
		mv.addObject("supplierList", this.supplierDAO.list());
		return mv;

	}

	// add ProductgetProductByID
	// method 2 for add Product
	@RequestMapping(value = "/manage_product_create", method = RequestMethod.POST)
	public ModelAndView createProduct(@Valid @ModelAttribute(value = "createProductObj") Product product,
			MultipartFile file, Model model, BindingResult result) {
		System.out.println("createProduct called****");
		ModelAndView mv = new ModelAndView("home");
		if (result.hasErrors())
			return new ModelAndView("createProductForm");

		else {
			Category category = categoryDAO.getCategoryByName(product.getCategory().getName());
			System.out.println(category.getId() + ":" + category.getName() + ":" + category.getDescription());
			Supplier supplier = supplierDAO.getSupplierByName(product.getSupplier().getName());
			System.out.println(supplier.getId() + ":" + supplier.getName() + ":" + supplier.getAddress());

			product.setCategory(category);
			product.setSupplier(supplier);
			productDAO.save(product);
			mv.addObject("isUserClickedProducts", "true");
			mv.addObject("productList", productDAO.list());

			MultipartFile prodImage = product.getImage();
			System.out.println(prodImage);
			if (prodImage != null || !prodImage.isEmpty()) {

				// store this Image
				Path paths = Paths.get("E:/Ecommerce_Project_1/ecommerce/src/main/webapp/WEB-INF/resources/images/"
						+ product.getId() + ".png");
				try {
					prodImage.transferTo(new File(paths.toString()));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return mv;

	}

	// delete Product
	@RequestMapping(value = "/manage_product_delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(value = "id") int id, Model model) {
		System.out.println("deleteProduct called****");

		/*
		 * ModelAndView mv = new ModelAndView("adminHome"); Product product =
		 * (Product) productDAO.getProductByID(id); if
		 * (productDAO.delete(product)) { mv.addObject("messsage",
		 * "Successfully deleted the product"); } else {
		 * mv.addObject("messsage",
		 * "Not able to delete the  product,so please contact administrator"); }
		 * 
		 * model.addAttribute("productList", productDAO.list());
		 * mv.addObject("isUserClickedProducts", "true"); return mv;
		 */
		Product product = productDAO.getProductByID(id);
		productDAO.delete(product);

		Path paths = Paths
				.get("E:/Ecommerce_Project_1/ecommerce/src/main/webapp/WEB-INF/resources/images/" + id + ".png");

		if (Files.exists(paths)) {
			try {

				Files.delete(paths);

			} catch (IOException e) {
			}
		}

		return "redirect:/getAllProducts";

	}

	// edit Product
	// method 1 for edit Product
	@RequestMapping(value = "/manage_product_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditProductForm(@PathVariable(value = "id") int id, HttpServletRequest request) {
		System.out.println("getEditProductForm called******");

		Product product = (Product) this.productDAO.getProductByID(id);
		System.out.println(product);

		// ModelAndView mv = new ModelAndView("editProductForm");
		// request.setAttribute("editProductObj", product);
		ModelAndView mv = new ModelAndView("editProductForm");
		mv.addObject("categoryList", this.categoryDAO.list());
		mv.addObject("supplierList", this.supplierDAO.list());
		mv.addObject("editProductObj", product);
		return mv;
	}

	// edit Product
	// method 2 for edit Product
	@RequestMapping(value = "/manage_product_edit", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute(value = "editProductObj") Product product, Model model) {
		System.out.println("editProduct  called****");

		productDAO.update(product);
		System.out.println("edit Product  finished**");
		return "redirect:/getAllProducts";

		/*
		 * ModelAndView mv = new ModelAndView("adminHome");
		 * model.addAttribute("productList", productDAO.list());
		 * mv.addObject("isUserClickedProducts", "true"); return mv;
		 * 
		 */

	}

	// view product details if productId is clicked
	@RequestMapping(value = "getProductsByProductId/{id}")
	public ModelAndView getProductsByProductId(@PathVariable(value = "id") int productId) {
		System.out.println("getProductsByProductId called***");
		Product product = productDAO.getProductByID(productId);
		System.out.println("getProductsByProductId called after productDAO **");
		return new ModelAndView("productPage", "product", product);
	}
}
