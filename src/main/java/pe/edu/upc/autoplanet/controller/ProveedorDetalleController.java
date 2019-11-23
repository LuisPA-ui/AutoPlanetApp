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
import pe.edu.upc.autoplanet.model.ProveedorDetalle;
import pe.edu.upc.autoplanet.service.CategoryService;
import pe.edu.upc.autoplanet.service.ClientService;
import pe.edu.upc.autoplanet.service.ProductService;
import pe.edu.upc.autoplanet.service.ProveedorDetalleService;
import pe.edu.upc.autoplanet.service.SupplierService;

@Controller
@RequestMapping("/proveedorDetalles")
public class ProveedorDetalleController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private ProveedorDetalleService proveedorDetalleService;
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/new")
	public String newProveedorDetalle(Model model) {
		model.addAttribute("proveedorDetalle", new ProveedorDetalle());
		model.addAttribute("listClients", clientService.getClients());
		model.addAttribute("listSuppliers", supplierService.getSuppliers());
		return "/supplier/formDetalle";
	}
	
	@PostMapping("/save")
	public String saveProveedorDetalle(
			@Valid ProveedorDetalle proveedorDetalle,
			BindingResult result,
			Model model,
			SessionStatus status) throws Exception {
		if(result.hasErrors()) {
			model.addAttribute("listClients", clientService.getClients());
			model.addAttribute("listSuppliers", supplierService.getSuppliers());
			return "/supplier/formDetalle";
		} else {
			
			if(proveedorDetalleService.createProveedorDetalle(proveedorDetalle) > 0) {
				model.addAttribute("message", "Ya existe.");
				model.addAttribute("listClients", clientService.getClients());
				model.addAttribute("listSuppliers", supplierService.getSuppliers());
				return "/supplier/formDetalle";
			} else {
				model.addAttribute("message", "Guardado con éxito.");
				status.setComplete();
			}
		}
		model.addAttribute("listProveedorDetalles", proveedorDetalleService.getProveedorDetalles());
		return "/supplier/listDetalle";
	}
	
	@GetMapping("/list")
	public String listProveedorDetalles(Model model) {
		try {
			model.addAttribute("listProveedorDetalles", proveedorDetalleService.getProveedorDetalles());
			model.addAttribute("proveedorDetalle", new ProveedorDetalle());
		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/supplier/listDetalle";
	}
	
	@RequestMapping("/delete")
	public String deleteProveedorDetalle(Model model, @RequestParam("id") Long id) {
		try {
			proveedorDetalleService.deleteProveedorDetalle(id);
			model.addAttribute("message", "Eliminado exitosamente.");
		} catch(Exception e) {
			model.addAttribute("message", "El Detalle no puede ser eliminado.");
		}
		model.addAttribute("listProveedorDetalles", proveedorDetalleService.getProveedorDetalles());
		return "/supplier/listDetalle";
	}

}
