package tech.maret.syskapi.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SyskController {
	
	//Login redirection
	@GetMapping("/login")
	public String login() { return "login";	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		//model.addAttribute("books", brepository.findAll());
		return "admin";
	}
	
	@GetMapping("/cities")
	public String admin(Model model) {
		//model.addAttribute("books", brepository.findAll());
		return "admin";
	}
	
	
}
