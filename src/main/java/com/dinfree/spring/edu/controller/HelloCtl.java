package com.dinfree.spring.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloCtl {
	@RequestMapping("/hello")
	public String hello(@RequestParam(value="name", required=false, defaultValue="HITLAB") String name, Model model){
        model.addAttribute("name", name);
        return "hello";
	}
}