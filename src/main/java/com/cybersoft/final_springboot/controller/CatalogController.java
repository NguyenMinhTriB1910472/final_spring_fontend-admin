package com.cybersoft.final_springboot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.cybersoft.final_springboot.entity.Catalog;
import com.example.final_spring.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/shop")
public class CatalogController {
	Utils utils =new Utils();
	@GetMapping("")
	public ModelAndView home() {
		ModelAndView andView = new ModelAndView("shop/shop");
		String response = utils.getDataTypeGet("http://localhost:8080/catalog/catalog_list");
		ObjectMapper mapper=new ObjectMapper();
		ObjectMapper objectMapper =new ObjectMapper();
		try {
			Catalog[] catalogs= mapper.readValue(response, Catalog[].class);
			andView.addObject("catalogs",catalogs);
//			for (Catalog catalog : catalogs) {
//				System.out.println(catalog.getName());
//			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response);
		return andView;
	}
}
	
