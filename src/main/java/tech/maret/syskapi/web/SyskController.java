package tech.maret.syskapi.web;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tech.maret.syskapi.domain.User;
import tech.maret.syskapi.domain.UserRepository;


@Controller
@RequestMapping("/")
public class SyskController {
	
	UserRepository uRepo;
	
	// --- Admin section -----------------------------------------------------------------------
	
	//Login redirection
	@GetMapping("/login")
	public String login() { return "login";	}
	
	
	
	
	// --- API -----------------------------------------------------------------------
	
}
