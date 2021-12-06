package com.jumia.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jumia.task.service.CustomerServiceImp;


@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
    private CustomerServiceImp customerService;

	@ResponseBody
    @GetMapping("/hello")
    public String info() {
        return "Hello to Customer db";
    }

	@GetMapping("/getCustomers")
    public String getCusetomers(
    		Model model){
		System.out.println(model.getAttribute("option"));
		model.addAttribute("customers", customerService.getCustomers());
		model.addAttribute("validatePhone", customerService.validatePhone());
        return "CustomerJSP";
    }
	
	@GetMapping("/Countryfilter")
    public String changeOption(Model model){
		model.addAttribute("customerFilter", customerService.getCustomersByCountryCode());
        return "CustomerFilterJSP";
    }
	
	

}
