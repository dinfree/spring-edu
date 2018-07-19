package com.dinfree.spring.edu.addrbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Spring boot 기반 주소록 프로그램
 * @author dinfree
 *
 */
@Controller
@RequestMapping("/addrbook")
public class AddrBookController {
	
	@Autowired 
	AddrBookDAO abdao;
		
	@GetMapping
	public String goMain(Model model, @PageableDefault(sort="id", direction = Sort.Direction.DESC, size = 4) Pageable pageable) {
        PageWrapper<AddrBook> page = new PageWrapper<AddrBook>(abdao.findAll(pageable), "/addrbook/"); 
        // view 에서 page.content 사용해야함.
        model.addAttribute("page",page);
        
		return "/addrbook/addrbook_list";
	}
	
	@GetMapping("/edit/{ab_id}")
	public String goEdit(@PathVariable int id, Model model){
		Optional<AddrBook> addrbook = abdao.findById(id);
		model.addAttribute("addrbook", addrbook);
		return "/addrbook/addrbook_edit_form";
	}

	@GetMapping("/form")
	public String goForm(@ModelAttribute("addrbook") AddrBook addrbook) {
	    //model.addAttribute("addrbook",new AddrBook());
		return "/addrbook/addrbook_form";
	}
	
	@PostMapping
	public String goAdd(@Valid @ModelAttribute("addrbook") AddrBook addrbook, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			/*
			System.out.println("error 발생..");
			for (ObjectError err : bindingResult.getAllErrors())
				System.out.println(err.getDefaultMessage());
			*/
			return "/addrbook/addrbook_form";
		}
		else {
			abdao.save(addrbook);
			return "redirect:/addrbook";
		}
	}
	
	@PostMapping(value="/update")
	public String goUpdate(AddrBook addrbook) {
		abdao.save(addrbook);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String goDelete(@PathVariable int id) {
		abdao.deleteById(id);
		return "redirect:/list";
	}
}
