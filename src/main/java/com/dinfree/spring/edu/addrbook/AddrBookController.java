package com.dinfree.spring.edu.addrbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
	@RequestMapping("/")
	public String goMain(Model model, Pageable pageable) {
        //TODO: sort 구현 필요
        PageWrapper<AddrBook> page = new PageWrapper<AddrBook>(abdao.findAll(pageable), "/addrbook/"); 
        // view 에서 page.content 사용해야함.
        model.addAttribute("page",page);
        
		return "/addrbook/addrbook_list";
	}
	
	@RequestMapping("/edit/{ab_id}")
	public String goEdit(@PathVariable int ab_id, Model model){
		AddrBook addrbook = abdao.findOne(ab_id);
		model.addAttribute("addrbook", addrbook);
		return "/addrbook/addrbook_edit_form";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String goAdd(AddrBook addrbook) {
		abdao.save(addrbook);
		return "redirect:/addrbook/";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String goUpdate(AddrBook addrbook) {
		abdao.save(addrbook);
		return "redirect:/addrbook/";
	}
	
	@RequestMapping("/delete/{ab_id}")
	public String goDelete(@PathVariable int ab_id) {
		abdao.delete(ab_id);
		return "redirect:/addrbook/";
	}
	
	@RequestMapping("/form")
	public String goForm() {
		return "/addrbook/addrbook_form";
	}
}
