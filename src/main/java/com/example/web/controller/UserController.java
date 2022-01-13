package com.example.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

	@GetMapping()
	public String index() {
		return "redirect:/login";
	}

	@GetMapping("/user")
	public String viewMyInfo(Model model, Authentication authentication) {
		model.addAttribute("myInfo", authentication.getPrincipal());
		return "myinfo";
	}

}