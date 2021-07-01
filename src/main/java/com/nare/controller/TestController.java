package com.nare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/get")
	public String test(Model model) {

		model.addAttribute("msg", "welcome narendra");
		return "welcome";

	}

	@GetMapping("/test")
	public String test1(Model model) {

		model.addAttribute("msg", "testing the application");
		return "welcome";

	}

}
