package tech.maret.syskapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.maret.syskapi.domain.User;
import tech.maret.syskapi.domain.UserAPI;
import tech.maret.syskapi.domain.UserAPIRepository;
import tech.maret.syskapi.domain.UserRepository;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserAPIRepository uApiRepo;
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
		model.addAttribute("users", uApiRepo.findAll());
		return "admin";
	}
	
	/**
	 * show page to add a user
	 * @param model
	 * @return addUser page
	 */
	@GetMapping("/userapi/create")
	public String addUser(Model model) {
		model.addAttribute("user", new UserAPI());
		//model.addAttribute("pwdRpt", new String());
		return "userAPI/addUserAPI";
	}
	
	/**
	 * Save the new user receive in param
	 * @param user
	 * @return redirect to admin page
	 */
	@PostMapping("/userapi/save")
	public String saveUser(UserAPI user){
		uApiRepo.save(user);
		return "redirect:/admin";
	}
	
	/**
	 * delete user func
	 * @param id user in the path and Model
	 * @return redirect admin page
	 */
	@GetMapping(value = "/userapi/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteUser(@PathVariable("id") Long idUser, Model model) {
		uApiRepo.deleteById(idUser);
		return "redirect:/admin";
	}
	
	/**
	 * go to page for updating user 
	 * @param id user in the path and Model
	 * @return  edit page
	 */	
	@GetMapping(value = "/userapi/edit/{id}")
	public String updateUser(@PathVariable("id") Long idUser, Model model) {
		UserAPI user = uApiRepo.findById(idUser).orElse(null);
		if(user == null) { 
			System.out.println("user with id: "+idUser+" not find");
			return "redirect:/admin";
		}
		model.addAttribute("user", user);
		return "userAPI/editUserAPI";
	}
	
	/**
	 * edit data of user 
	 * @param id user in the path and UserAPI
	 * @return redirect admin page
	 */
	@PostMapping("/userapi/edit/{id}")
	public String editUser(@PathVariable("id") Long idUser, UserAPI newUser){
		UserAPI oldUser = uApiRepo.findById(idUser).orElse(null) ;
		oldUser.setUsername(newUser.getUsername());
		oldUser.setRole(newUser.getRole());
		uApiRepo.save(oldUser);
		return "redirect:/admin";
	}
	
	/**
	 * go to page for updating user pwd
	 * @param id user in the path and Model
	 * @return editpwd page
	 */
	@GetMapping(value = "/userapi/newpwd/{id}")
	public String updatePassword(@PathVariable("id") Long idUser, Model model) {
		UserAPI user = uApiRepo.findById(idUser).orElse(null);
		if(user == null) { 
			System.out.println("user with id: "+idUser+" not find");
			return "redirect:/admin";
		}
		model.addAttribute("user", user);
		return "userAPI/editpwd";
	}
	
	/**
	 * edit user pwd
	 * @param id user in the path and UserAPI
	 * @return redirect admin page
	 */	
	@PostMapping("/userapi/newpwd/{id}")
	public String editPassword(@PathVariable("id") Long idUser, UserAPI newUser){
		UserAPI oldUser = uApiRepo.findById(idUser).orElse(null) ;
		System.out.println(newUser.getPasswordHash());
		oldUser.setPasswordWithoutHash(newUser.getPasswordHash());
		uApiRepo.save(oldUser);
		return "redirect:/admin";
	}
	
	
	// --- API -----------------------------------------------------------------------
}
