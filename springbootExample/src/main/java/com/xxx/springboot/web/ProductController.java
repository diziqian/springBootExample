package com.xxx.springboot.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xxx.springboot.entity.Product;
import com.xxx.springboot.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getDefault() {
		return "Hello, world!";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(){
		
		List<Product> list = productService.list();
		return list.toString();
	}
	
	@ResponseBody
	@JsonIgnoreProperties(value = { "handler" })
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public  Map<String, Object> getAll(){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Product> list = productService.list();
		if(list.size() > 0) {
			System.out.print("List is: ");
			System.out.println(list.get(0).toString());
		}
		
		modelMap.put("data", list);
		
		System.out.println(modelMap);
		return modelMap;
	}
	
	@ResponseBody
	@RequestMapping(value="/getOne", method=RequestMethod.GET)
	public  Product getOne(){
		List<Product> list = productService.list();
		if(list.size() > 0) {
			System.out.print("List is: ");
			System.out.println(list.get(0).toString());
			return list.get(0);
		}
		
		return null;
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public Map<String, Object> get(@PathVariable("id")int id){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Product product = productService.queryById(id);
		modelMap.put("data", product);
		return modelMap;
	}
}
