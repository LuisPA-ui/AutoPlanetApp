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

import pe.edu.upc.autoplanet.model.Cita;
import pe.edu.upc.autoplanet.model.Product;
import pe.edu.upc.autoplanet.service.CategoryService;
import pe.edu.upc.autoplanet.service.CitaService;
import pe.edu.upc.autoplanet.service.ClientService;
import pe.edu.upc.autoplanet.service.ProductService;
import pe.edu.upc.autoplanet.service.SupplierService;

@Controller
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CitaService citaService;
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/new")
	public String newCita(Model model) {
		model.addAttribute("cita", new Cita());
		model.addAttribute("listProducts", productService.getProducts());
		model.addAttribute("listClients", clientService.getClients());
		return "/cita/cita";
	}
	
	@PostMapping("/save")
	public String saveCita(
			@Valid Cita cita,
			BindingResult result,
			Model model,
			SessionStatus status) throws Exception {
		if(result.hasErrors()) {
			model.addAttribute("listProducts", productService.getProducts());
			model.addAttribute("listClients", clientService.getClients());
			return "/cita/cita";
		} else {
			if(citaService.createCita(cita) > 0) {
				model.addAttribute("message", "Ya existe.");
				model.addAttribute("listProducts", productService.getProducts());
				model.addAttribute("listClients", clientService.getClients());
				return "/cita/cita";
			} else {
				model.addAttribute("message", "Guardado con éxito.");
				status.setComplete();
			}
		}
		model.addAttribute("listCitas", citaService.getCitas());
		return "/cita/listCitas";
	}
	
	@GetMapping("/list")
	public String listProducts(Model model) {
		try {
			model.addAttribute("listCitas", citaService.getCitas());
			model.addAttribute("cita", new Cita());
		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/cita/listCitas";
	}
	
	@RequestMapping("/delete")
	public String deleteCita(Model model, @RequestParam("id") Long id) {
		try {
			citaService.deleteCita(id);
			model.addAttribute("message", "Eliminado exitosamente.");
		} catch(Exception e) {
			model.addAttribute("message", "El producto no puede ser eliminado.");
		}
		model.addAttribute("listProducts", citaService.getCitas());
		return "/cita/listCitas";
	}

}
