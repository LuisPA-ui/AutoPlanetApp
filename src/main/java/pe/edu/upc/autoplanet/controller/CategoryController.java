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

import pe.edu.upc.autoplanet.model.Category;
import pe.edu.upc.autoplanet.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/new")
	public String newCategory(Model model) {
		model.addAttribute("category", new Category());
		return "category/category";
	}
	
	@PostMapping("/save")
	public String saveCategory(
			@Valid Category category,
			BindingResult result,
			Model model,
			SessionStatus status) throws Exception {
	
		if(result.hasErrors()) {
			return "/category/category";
		} else {
			if(categoryService.createCategory(category) > 0) {
				model.addAttribute("message", "Ya existe.");
			} else {
				model.addAttribute("message", "Guardado con éxito.");
				status.setComplete();
			}
		}
		model.addAttribute("listCategories", categoryService.getCategories());
		return "/category/listCategories";
	}
	
	@GetMapping("/list")
	public String listCategories(Model model) {
		try {
			model.addAttribute("category", new Category());
			model.addAttribute("listCategories", categoryService.getCategories());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/category/listCategories";
	}
	
	@RequestMapping("/delete")
	public String deleteCategory(Model model, @RequestParam("id") Long id) {
		try {
			categoryService.deleteCategory(id);
			model.addAttribute("message", "Eliminado exitosamente.");

		} catch(Exception e) {
			model.addAttribute("message", "La categoría no se puede eliminar.");
		}
		model.addAttribute("listCategories", categoryService.getCategories());
		return "/category/listCategories";
	}

}
