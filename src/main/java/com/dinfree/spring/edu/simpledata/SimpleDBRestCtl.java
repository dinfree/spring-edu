package com.dinfree.spring.edu.simpledata;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simple")
public class SimpleDBRestCtl {

	@Autowired
	private SimpleDataDAO sdao;
	
	@PostMapping("/add")
	public SimpleData add(@RequestBody SimpleData sd) {
		SimpleData data = sdao.save(sd);
		return data;
	}
	
	@GetMapping("/update")
	public SimpleData update(SimpleData sd) {
		SimpleData data = sdao.save(sd);
		return data;
	}
	
	@GetMapping("/{id}")
	public Optional<SimpleData> get(@PathVariable int id) {
		Optional<SimpleData> data = sdao.findById(id);
		return data;
	}
	
	@GetMapping("/list")
	public List<SimpleData> list(Model model) {
		List<SimpleData> sdList= sdao.findAll();
		return sdList;
	}
	
	@GetMapping("/delete/{id}")
	public String list(@PathVariable int id) {
		sdao.deleteById(id);
		return "Deleted";
	}
	
	@GetMapping
	public String index() {
		return "SimpleData JPA with H2 DB";
	}
}
