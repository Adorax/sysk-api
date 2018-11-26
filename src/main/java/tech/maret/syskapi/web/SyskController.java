package tech.maret.syskapi.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
	


@Controller
@RequestMapping("/")
public class SyskController {
	
	
	// --- Admin section -----------------------------------------------------------------------
	
	/**
	 * Login redirection
	 * @param 
	 * @return login page
	 */
	@GetMapping("/login")
	public String login() { return "login";	}
	
	/**
	 * Show the admin page
	 * @param 
	 * @return redirect admin page
	 */
	@GetMapping("")
	public String admin(){
		return "redirect:/admin";
	}
	
}
