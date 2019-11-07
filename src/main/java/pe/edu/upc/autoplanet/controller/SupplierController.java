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

import pe.edu.upc.autoplanet.model.Supplier;
import pe.edu.upc.autoplanet.service.SupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/new")
	public String newSupplier(Model model) {
		model.addAttribute("supplier", new Supplier());
		return "supplier/supplier";
	}
	
	@PostMapping("/save")
	public String saveSupplier(
			@Valid Supplier supplier,
			BindingResult result,
			Model model,
			SessionStatus status) throws Exception {
	
		if(result.hasErrors()) {
			return "/supplier/supplier";
		} else {
			if(supplierService.createSupplier(supplier) > 0) {
				model.addAttribute("message", "Ya existe.");
			} else {
				model.addAttribute("message", "Guardado con éxito.");
				status.setComplete();
			}
		}
		model.addAttribute("listSuppliers", supplierService.getSuppliers());
		return "/supplier/listSuppliers";
	}
	
	@GetMapping("/list")
	public String listSuppliers(Model model) {
		try {
			model.addAttribute("supplier", new Supplier());
			model.addAttribute("listSuppliers", supplierService.getSuppliers());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/supplier/listSuppliers";
	}
	
	@RequestMapping("/delete")
	public String deleteSupplier(Model model, @RequestParam("id") Long id) {
		try {
			supplierService.deleteSupplier(id);
			model.addAttribute("message", "Eliminado exitosamente.");

		} catch(Exception e) {
			model.addAttribute("message", "El proveedor no se puede eliminar.");
		}
		model.addAttribute("listSuppliers", supplierService.getSuppliers());
		return "/supplier/listSuppliers";
	}

}
