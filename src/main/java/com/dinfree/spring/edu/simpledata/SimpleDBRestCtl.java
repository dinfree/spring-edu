package com.dinfree.spring.edu.simpledata;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleDBRestCtl {
	@Autowired
	private SimpleDataDAO sdao;
	
	@RequestMapping("/simple/add")
	public SimpleData add(SimpleData sd) {
		SimpleData data = sdao.save(sd);
		return data;
	}
	
	@RequestMapping("/simple/list")
	public List<SimpleData> list(Model model) {
		List<SimpleData> sdList= sdao.findAll();
		return sdList;
	}
	
	@RequestMapping("/simple/delete/{id}")
	public String list(@PathVariable int id, Model model) {
		sdao.delete(id);
		return "Deleted";
	}
	
	@RequestMapping("/simple")
	public String index() {
		return "SimpleData JPA with H2 DB";
	}
}
