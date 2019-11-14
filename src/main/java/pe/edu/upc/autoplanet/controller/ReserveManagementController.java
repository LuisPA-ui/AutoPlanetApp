package pe.edu.upc.autoplanet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.autoplanet.model.ReserveManagement;
import pe.edu.upc.autoplanet.service.ReserveManagementService;

@Controller
@RequestMapping("/ReserveManagement")
public class ReserveManagementController {

	@Autowired
	private ReserveManagementService ReserveManagentService;
	
	@GetMapping("/new")
	public String newReseve(Model model) {
		model.addAttribute("ReseveManagement", new ReserveManagement());
		return "ReseveManagement/ReseveManagement";
	}
	
	@PostMapping("/save")
	public String saveReserve(
			@Valid ReserveManagement Reserve,
			BindingResult result,
			Model model,
			SessionStatus status) throws Exception {
	
		if(result.hasErrors()) {
			return "/reserveManagement/reserveManagement";
		} else {
			if(ReserveManagementService.createReserve(ReserveManagement) > 0) {
				model.addAttribute("message", "Ya existe.");
			} else {
				model.addAttribute("message", "Guardado con éxito.");
				status.setComplete();
			}
		}
		model.addAttribute("listReseve", ReserveManagementServic.getReserve());
		return "/client/listClients";
	}
	
	@GetMapping("/list")
	public String listReseve(Model model) {
		try {
			model.addAttribute("Reseve", new );
			model.addAttribute("lisReseve", );
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/client/listClients";
	}
	
	@RequestMapping("/delete")
	public String deleteClient(Model model, @RequestParam("id") Long id) {
		try {
			clientService.deleteClient(id);
			model.addAttribute("message", "Eliminado exitosamente.");

		} catch(Exception e) {
			model.addAttribute("message", "El cliente no se puede eliminar.");
		}
		model.addAttribute("listClients", clientService.getClients());
		return "/client/listClients";
	}

}
