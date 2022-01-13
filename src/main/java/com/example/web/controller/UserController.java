package com.example.web.controller;

import com.example.web.model.User;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping()
	public String index() {
		return "redirect:/login";
	}

	@GetMapping("/user")
	public String viewMyInfo(Model model, Authentication authentication) {
		model.addAttribute("user", (User)authentication.getPrincipal());

		return "/user/myInfo";
	}

}