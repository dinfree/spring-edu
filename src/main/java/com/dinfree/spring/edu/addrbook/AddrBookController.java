package com.dinfree.spring.edu.addrbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
		
	@GetMapping("/")
	public String goMain(Model model, @PageableDefault(sort="id", direction = Sort.Direction.DESC, size = 4) Pageable pageable) {
        PageWrapper<AddrBook> page = new PageWrapper<AddrBook>(abdao.findAll(pageable), "/addrbook/"); 
        // view 에서 page.content 사용해야함.
        model.addAttribute("page",page);
        
		return "/addrbook/addrbook_list";
	}
	
	@GetMapping("/edit/{ab_id}")
	public String goEdit(@PathVariable int ab_id, Model model){
		AddrBook addrbook = abdao.findOne(ab_id);
		model.addAttribute("addrbook", addrbook);
		return "/addrbook/addrbook_edit_form";
	}
	
	@PostMapping(value = "/add")
	public String goAdd(AddrBook addrbook) {
		abdao.save(addrbook);
		return "redirect:/addrbook/";
	}
	
	@PostMapping(value="/update")
	public String goUpdate(AddrBook addrbook) {
		abdao.save(addrbook);
		return "redirect:/addrbook/";
	}
	
	@GetMapping("/delete/{ab_id}")
	public String goDelete(@PathVariable int ab_id) {
		abdao.delete(ab_id);
		return "redirect:/addrbook/";
	}
	
	@GetMapping("/form")
	public String goForm() {
		return "/addrbook/addrbook_form";
	}
}
