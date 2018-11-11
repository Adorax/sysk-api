package tech.maret.syskapi.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.maret.syskapi.domain.User;
import tech.maret.syskapi.domain.UserRepository;

@Controller
@RequestMapping("/admin/user/")
public class UserController {
UserRepository uRepo;
	
	// --- Admin section -----------------------------------------------------------------------
	
	//Login redirection
	@GetMapping("/login")
	public String login() { return "login";	}
	
	/**
	 * Show the admin page
	 * @param model
	 * @return admin page
	 */
	@GetMapping("/index")
	public String admin(Model model) {
		model.addAttribute("users", uRepo.findAll());
		return "admin";
	}
	
	/**
	 * show page to add a user
	 * @param model
	 * @return addUser page
	 */
	@GetMapping("/add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}
	
	/**
	 * Save the new user receive in param
	 * @param user
	 * @return redirect to admin page
	 */
	@PostMapping("/save")
	public String saveUser(User user){
		uRepo.save(user);
		return "redirect:index";
	}
	
	@GetMapping(value = "/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteUser(@PathVariable("id") Long idUser, Model model) {
		uRepo.deleteById(idUser);
		return "redirect:../index";
	}
	
	@GetMapping(value = "/{id}")
	public String updateUser(@PathVariable("id") Long idUser, Model model) {
		User user = uRepo.findById(idUser).orElse(null);
		if(user == null) { 
			System.out.println("user with id: "+idUser+" not find");
			return "redirect:index";
		}
		model.addAttribute("user", user);
		return "editUser";
	}
	
	
	// --- API -----------------------------------------------------------------------
}
