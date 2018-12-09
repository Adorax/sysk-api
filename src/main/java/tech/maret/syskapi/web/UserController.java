package tech.maret.syskapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tech.maret.syskapi.domain.User;
import tech.maret.syskapi.domain.UserAPI;
import tech.maret.syskapi.domain.User;
import tech.maret.syskapi.domain.UserRepository;
import tech.maret.syskapi.domain.UserRepository;


@Controller
@RequestMapping("/admin/user")
public class UserController {
	
	@Autowired
	UserRepository uRepo;
	//Bean entityManagerFactory;
	
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
	 * @param model
	 * @return admin page
	 */
	@GetMapping("")
	public String admin(Model model) {
		model.addAttribute("users", uRepo.findAll());
		return "user/user";
	}
	
	/**
	 * show page to add a user
	 * @param model
	 * @return addUser page
	 */
	@GetMapping("/create")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "user/adduser";
	}
	
	/**
	 * Save the new user receive in param
	 * @param user
	 * @return redirect to admin page
	 */
	@PostMapping("/save")
	public String saveUser(User user){
		uRepo.save(user);
		return "redirect:/admin/user";
	}
	
	/**
	 * delete user func
	 * @param id user in the path and Model
	 * @return redirect admin page
	 */
	@GetMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteUser(@PathVariable("id") Long idUser, Model model) {
		uRepo.deleteById(idUser);
		return "redirect:/admin/user";
	}
	
	/**
	 * go to page for updating user 
	 * @param id user in the path and Model
	 * @return  edit page
	 */	
	@GetMapping(value = "/edit/{id}")
	public String updateUser(@PathVariable("id") Long idUser, Model model) {
		User user = uRepo.findById(idUser).orElse(null);
		if(user == null) { 
			System.out.println("user with id: "+idUser+" not find");
			return "redirect:/admin/user";
		}
		model.addAttribute("user", user);
		return "user/edituser";
	}
	
	/**
	 * edit data of user 
	 * @param id user in the path and User
	 * @return redirect admin page
	 */
	@PostMapping("/edit/{id}")
	public String editUser(@PathVariable("id") Long idUser, User newUser){
		User oldUser = uRepo.findById(idUser).orElse(null) ;
		oldUser.setUsername(newUser.getUsername());
		oldUser.setEmail(newUser.getEmail());
		uRepo.save(oldUser);
		return "redirect:/admin/user";
	}
	
	/**
	 * go to page for updating user pwd
	 * @param id user in the path and Model
	 * @return editpwd page
	 */
	@GetMapping(value = "/newpwd/{id}")
	public String updatePassword(@PathVariable("id") Long idUser, Model model) {
		User user = uRepo.findById(idUser).orElse(null);
		if(user == null) { 
			System.out.println("user with id: "+idUser+" not find");
			return "redirect:/admin/user";
		}
		model.addAttribute("user", user);
		return "user/editpwd";
	}
	
	/**
	 * edit user pwd
	 * @param id user in the path and User
	 * @return redirect admin page
	 */	
	@PostMapping("/newpwd/{id}")
	public String editPassword(@PathVariable("id") Long idUser, User newUser){
		User oldUser = uRepo.findById(idUser).orElse(null) ;
		System.out.println(newUser.getPasswordHash());
		oldUser.setPasswordWithoutHash(newUser.getPasswordHash());
		uRepo.save(oldUser);
		return "redirect:/admin/user";
	}
	
	
	// --- API -----------------------------------------------------------------------
	

}
