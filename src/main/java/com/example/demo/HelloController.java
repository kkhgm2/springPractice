package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MyData;
import com.example.demo.repository.MyDataRepositry;

@Controller
public class HelloController {
	
	@Autowired
	MyDataRepositry repository;
	
	@GetMapping("/")
	public String index(Model model) {
		
		Iterable<MyData> list = repository.findAll();
		model.addAttribute("msg", "お名前を入力してください");
		model.addAttribute("data", list);
		
		return "index";
	}

	@PostMapping("/")
	public String post(
			@RequestParam(value = "checkbox1", required=false) String checkbox1, 
			@RequestParam(value = "radio1", required=false) String radio1, 
			@RequestParam(value = "select1", required=false) String select1, 
			@RequestParam(value = "select2", required=false) String select2, 
			Model model) {
		
		String str = "";
		str = "check : " + checkbox1 + ", radio1 : " + radio1 + ", select1 : " + select1 
				+ ", select2 : " + select2;
		
		model.addAttribute("msg", str);
		
		return "index";
	}
	
	@GetMapping("other")
	public String othre() {
		return "redirect:/";
	}
	
	@GetMapping("home")
	public String home() {
		return "forward:/";
	}
}