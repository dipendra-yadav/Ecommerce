package com.niit.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.CategoryDAO;
import com.niit.ecommerce.domain.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;

	// displays all the Categories in the table
	@RequestMapping(value = "/getAllCategories")
	public ModelAndView getAllCategories() {
		List<Category> allcategories = categoryDAO.list();
		ModelAndView mv = new ModelAndView("category", "categoryList", allcategories);

		return mv;
	}

	// add Category
	// method 1 for add Categry
	@RequestMapping("/manage_category_create")
	public ModelAndView getcreateCategoryForm() {
		System.out.println("getcreateCategoryForm called*****************");
		ModelAndView mv = new ModelAndView("/createCategoryForm");
		mv.addObject("createCategoryObj", category);
		return mv;

	}

	// add Category
	// method 2 for add Categry
	@RequestMapping(value = "/manage_category_create", method = RequestMethod.POST)
	public ModelAndView createCategory(@Valid @ModelAttribute(value = "createCategoryObj") Category category,
			BindingResult result) {
		System.out.println("create category called*****************");

		ModelAndView mv = new ModelAndView("adminHome");
		if (result.hasErrors())
			return new ModelAndView("createCategoryForm");
		if (categoryDAO.save(category)) {
			mv.addObject("message", "Successfully created the category");
			List<Category> categoryList = categoryDAO.list();
			mv.addObject("categoryList", categoryList);

		} else {
			mv.addObject("message", "Not able to create Category.Please contact Administrator");

		}
		mv.addObject("isUserClickedCategories", "true");
		return mv;

	}

	// @GetMapping("/manage_category_delete/{id}")
	@RequestMapping(value = "/manage_category_delete/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable(value = "id") int id, Model model) {
		System.out.println("delete Category called****");

		/*
		 * ModelAndView mv = null; Category category = (Category)
		 * categoryDAO.getCategoryByID(id); if (categoryDAO.delete(category)) {
		 * mv = new ModelAndView("adminHome"); mv.addObject("messsage",
		 * "Successfully deleted the category");
		 * 
		 * model.addAttribute("categoryList", categoryDAO.list());
		 * mv.addObject("isUserClickedCategories", "true"); return mv; } else {
		 * mv.addObject("messsage",
		 * "Not able to delete the  category,so please contact administrator");
		 * mv = new ModelAndView("adminHome");
		 * mv.addObject("isUserClickedCategories", "true"); return mv; }
		 */
		Category category = categoryDAO.getCategoryByID(id);
		categoryDAO.delete(category);
		return "redirect:/getAllCategories";

	}

	// edit Category
	// method 1 for edit Categry
	@RequestMapping(value = "/manage_category_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditCategoryForm(@PathVariable(value = "id") int id) {
		System.out.println("getEditForm called******");
		Category category = this.categoryDAO.getCategoryByID(id);
		return new ModelAndView("editCategoryForm", "editCategoryObj", category);
	}

	// edit Category
	// method 2 for edit Categry
	@RequestMapping(value = "/manage_category_edit", method = RequestMethod.POST)
	public String editCategory(@ModelAttribute(value = "editCategoryObj") Category category, Model model) {
		System.out.println("edit category called****");
		this.categoryDAO.update(category);
		return "redirect:/getAllCategories";

		/*
		 * ModelAndView mv = new ModelAndView("adminHome");
		 * model.addAttribute("categoryList", categoryDAO.list());
		 * mv.addObject("isUserClickedCategories", "true");
		 * 
		 */

	}
}
