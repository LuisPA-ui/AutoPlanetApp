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

import pe.edu.upc.autoplanet.model.Car;
import pe.edu.upc.autoplanet.service.CarService;
import pe.edu.upc.autoplanet.service.ClientService;


@Controller
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private CarService carService;
	
	@GetMapping("/new")
	public String newCar(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("listClients", clientService.getClients());
		return "/car/car";
	}
	
	@PostMapping("/save")
	public String saveCar(
			@Valid Car car,
			BindingResult result,
			Model model,
			SessionStatus status) throws Exception {
		if(result.hasErrors()) {
			model.addAttribute("listClients", clientService.getClients());
			return "/car/car";
		} else {
			if(carService.createCar(car) > 0) {
				model.addAttribute("message", "Ya existe.");
				model.addAttribute("listClients", clientService.getClients());
				return "/car/car";
			} else {
				model.addAttribute("message", "Guardado con éxito.");
				status.setComplete();
			}
		}
		model.addAttribute("listCars", carService.getCars());
		return "/car/listCars";
	}
	
	@GetMapping("/list")
	public String listCars(Model model) {
		try {
			model.addAttribute("listCars", carService.getCars());
			model.addAttribute("car", new Car());
		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/car/listCars";
	}
	
	@RequestMapping("/delete")
	public String deleteCar(Model model, @RequestParam("id") Long id) {
		try {
			carService.deleteCar(id);
			model.addAttribute("message", "Eliminado exitosamente.");
		} catch(Exception e) {
			model.addAttribute("message", "El auto no puede ser eliminado.");
		}
		model.addAttribute("listCars", carService.getCars());
		return "/car/listCar";
	}

}