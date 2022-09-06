package com.cybersoft.final_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.cybersoft.final_springboot.pojo.Order;
import com.example.final_spring.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
Utils utils = new Utils();
	
	@GetMapping("")
	public ModelAndView user() {
		ModelAndView andView = new ModelAndView("/LayoutCrm/order");
		String response = utils.getDataTypeGet("http://localhost:8090/api/order");
		System.out.println(response);

		// Chuyển data nhận từ api --> object (jackson)
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Order[] orders = mapper.readValue(response, Order[].class);
			andView.addObject("orders", orders);
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return andView;
	}
}

	
