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

import com.niit.ecommerce.dao.SupplierDAO;
import com.niit.ecommerce.domain.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	// Gett all suppliers
	@RequestMapping(value = "/getAllSuppliers")
	public ModelAndView getAllCategories() {
		List<Supplier> allsuppliers = supplierDAO.list();
		ModelAndView mv = new ModelAndView("supplier", "supplierList", allsuppliers);
		return mv;
	}

	// add Supplier
	// method 1 for add Supplier
	@RequestMapping("/manage_supplier_create")
	public ModelAndView createSupplierForm() {
		System.out.println("createSupplierForm called*****************");
		ModelAndView mv = new ModelAndView("/createSupplierForm");
		mv.addObject("createSupplierObj", supplier);
		return mv;

	}

	// add Supplier
	// method 2 for add Supplier
	@RequestMapping(value = "/manage_supplier_create", method = RequestMethod.POST)
	public ModelAndView createSupplier(@Valid @ModelAttribute(value = "createSupplierObj") Supplier supplier,
			BindingResult result) {
		System.out.println("createSupplier called****");

		ModelAndView mv = new ModelAndView("adminHome");
		if (result.hasErrors())
			return new ModelAndView("createSupplierForm");

		if (supplierDAO.save(supplier)) {
			mv.addObject("message", "Successfully created the Supplier");
			List<Supplier> supplierList = supplierDAO.list();
			mv.addObject("supplierList", supplierList);

		} else {
			mv.addObject("message", "Not able to create Product.Please contact Administrator");

		}
		mv.addObject("isUserClickedSuppliers", "true");
		return mv;

	}

	// delete a supplier
	@RequestMapping(value = "/manage_supplier_delete/{id}", method = RequestMethod.GET)
	public String deleteSupplier(@PathVariable(value = "id") int id, Model model) {
		System.out.println("deleteSupplier called****");

		/*
		 * ModelAndView mv = new ModelAndView("adminHome");
		 * mv.addObject("isUserClickedSuppliers", "true");
		 * 
		 * Supplier supplier = (Supplier) supplierDAO.getSupplierByID(id); if
		 * (supplierDAO.delete(supplier)) { mv.addObject("messsage",
		 * "Successfully deleted the supplier"); List<Supplier> supplierList =
		 * supplierDAO.list(); mv.addObject("supplierList", supplierList); }
		 * else { mv.addObject("messsage",
		 * "Not able to delete the  supplier,so please contact administrator");
		 * }
		 */
		Supplier supplier = supplierDAO.getSupplierByID(id);
		supplierDAO.delete(supplier);
		return "redirect:/getAllSuppliers";

	}

	// edit Supplier
	// method 1 for edit Supplier
	@RequestMapping(value = "/manage_supplier_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditSupplierForm(@PathVariable(value = "id") int id) {
		System.out.println("getEditSupplierForm called******");
		Supplier supplier = (Supplier) this.supplierDAO.getSupplierByID(id);
		return new ModelAndView("editSupplierForm", "editSupplierObj", supplier);
	}

	// edit Supplier
	// method 2 for edit Supplier
	@RequestMapping(value = "/manage_supplier_edit", method = RequestMethod.POST)
	public String editSupplier(@ModelAttribute(value = "editSupplierObj") Supplier supplier, Model model) {
		System.out.println("editSupplier  called****");

		this.supplierDAO.update(supplier);
		/*
		 * ModelAndView mv = new ModelAndView("adminHome");
		 * 
		 * model.addAttribute("supplierList", supplierDAO.list());
		 * mv.addObject("isUserClickedSuppliers", "true"); return mv;
		 */

		return "redirect:/getAllSuppliers";

	}

}
