package pe.edu.upc.autoplanet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.autoplanet.model.Product;
import pe.edu.upc.autoplanet.service.CategoryService;
import pe.edu.upc.autoplanet.service.ProductService;
import pe.edu.upc.autoplanet.service.SupplierService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listCategories", categoryService.getCategories());
		model.addAttribute("listSuppliers", supplierService.getSuppliers());
		return "/product/product";
	}
	
	@PostMapping("/save")
	public String saveProduct(
			@Valid Product product,
			BindingResult result,
			Model model,
			SessionStatus status) throws Exception {
		if(result.hasErrors()) {
			model.addAttribute("listCategories", categoryService.getCategories());
			model.addAttribute("listSuppliers", supplierService.getSuppliers());
			return "/product/product";
		} else {
			if(productService.createProduct(product) > 0) {
				model.addAttribute("message", "Ya existe.");
				model.addAttribute("listCategories", categoryService.getCategories());
				model.addAttribute("listSuppliers", supplierService.getSuppliers());
				return "/product/product";
			} else {
				model.addAttribute("message", "Guardado con éxito.");
				status.setComplete();
			}
		}
		model.addAttribute("listProducts", productService.getProducts());
		return "/product/listProducts";
	}
	
	@GetMapping("/list")
	public String listProducts(Model model) {
		try {
			model.addAttribute("listProducts", productService.getProducts());
			model.addAttribute("product", new Product());
		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/product/listProducts";
	}
	
	@RequestMapping("/delete")
	public String deleteProduct(Model model, @RequestParam("id") Long id) {
		try {
			productService.deleteProduct(id);
			model.addAttribute("message", "Eliminado exitosamente.");
		} catch(Exception e) {
			model.addAttribute("message", "El producto no puede ser eliminado.");
		}
		model.addAttribute("listProducts", productService.getProducts());
		return "/product/listProduct";
	}

}
