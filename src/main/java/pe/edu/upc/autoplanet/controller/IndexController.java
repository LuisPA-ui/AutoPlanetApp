package pe.edu.upc.autoplanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class IndexController {
	
	@GetMapping
	public String index() {
		return "index";
	}

}
