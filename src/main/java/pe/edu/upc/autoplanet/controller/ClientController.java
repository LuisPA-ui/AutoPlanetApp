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

import pe.edu.upc.autoplanet.model.Client;
import pe.edu.upc.autoplanet.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/new")
	public String newClient(Model model) {
		model.addAttribute("client", new Client());
		return "client/client";
	}
	
	@PostMapping("/save")
	public String saveClient(
			@Valid Client client,
			BindingResult result,
			Model model,
			SessionStatus status) throws Exception {
	
		if(result.hasErrors()) {
			return "/client/client";
		} else {
			if(clientService.createClient(client) > 0) {
				model.addAttribute("message", "Ya existe.");
			} else {
				model.addAttribute("message", "Guardado con éxito.");
				status.setComplete();
			}
		}
		model.addAttribute("listClients", clientService.getClients());
		return "/client/listClients";
	}
	
	@GetMapping("/list")
	public String listClients(Model model) {
		try {
			model.addAttribute("client", new Client());
			model.addAttribute("listClients", clientService.getClients());
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
